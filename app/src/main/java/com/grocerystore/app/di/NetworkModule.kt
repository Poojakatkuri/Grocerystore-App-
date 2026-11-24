package com.grocerystore.app.di

import com.grocerystore.app.BuildConfig
import com.grocerystore.app.data.network.SupabaseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.auth.Auth
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

// FLOW step 1 (network setup): builds ONE shared Retrofit client for Supabase's REST API.
// Hilt gives SupabaseApi to any repository that asks for it in its constructor.
// Login (Auth) and file uploads (Storage) still use the Supabase SDK in SupabaseModule.
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Used only when SUPABASE_URL in local.properties is missing or not a valid URL:
    // requests then fail (and are caught by the repositories) instead of crashing the app.
    private const val NOT_CONFIGURED_URL = "https://supabase-url-not-configured.invalid/"

    @Provides
    @Singleton
    fun provideSupabaseApi(auth: Auth): SupabaseApi = createSupabaseApi(
        baseUrl = BuildConfig.SUPABASE_URL,
        apiKey = BuildConfig.API_KEY,
        // Logged-in user's token if there is one, so row-level security rules see the real user.
        userAccessToken = { auth.currentAccessTokenOrNull() },
    )

    internal fun createSupabaseApi(
        baseUrl: String,
        apiKey: String,
        userAccessToken: () -> String?,
        okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder(),
    ): SupabaseApi {
        // Supabase needs two headers on every request:
        //   apikey        -> identifies the project (public "anon" key)
        //   Authorization -> who is calling: the logged-in user's token, or the anon key
        val supabaseHeaders = Interceptor { chain ->
            val bearer = userAccessToken() ?: apiKey
            chain.proceed(
                chain.request().newBuilder()
                    .header("apikey", apiKey)
                    .header("Authorization", "Bearer $bearer")
                    .build()
            )
        }
        // Index 0 so the headers are added before any other interceptor runs.
        okHttpBuilder.interceptors().add(0, supabaseHeaders)

        // Same JSON settings the Supabase SDK uses: ignore fields the DTOs don't declare.
        val json = Json { ignoreUnknownKeys = true }

        return Retrofit.Builder()
            .baseUrl(supabaseBaseUrl(baseUrl))
            .client(okHttpBuilder.build())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(SupabaseApi::class.java)
    }

    // Accepts "https://xyz.supabase.co", "xyz.supabase.co" or a trailing "/" and returns a valid base URL.
    internal fun supabaseBaseUrl(raw: String): HttpUrl {
        val trimmed = raw.trim()
        val withScheme =
            if (trimmed.startsWith("https://") || trimmed.startsWith("http://")) trimmed else "https://$trimmed"
        val withSlash = if (withScheme.endsWith("/")) withScheme else "$withScheme/"
        return withSlash.toHttpUrlOrNull() ?: NOT_CONFIGURED_URL.toHttpUrl()
    }
}
