package com.grocerystore.app.di

import com.grocerystore.app.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.serializer.KotlinXSerializer
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import javax.inject.Singleton
import kotlinx.serialization.json.Json

// Supabase SDK client, shared by the whole app. Still used for:
//   - Auth (sign up / sign in / sign out) and Storage (meal image uploads)
//   - the remaining tables (orders, users, meal plans) through Postgrest
// Products and categories now use Retrofit instead: see NetworkModule (FLOW step 1).
@Module
@InstallIn(SingletonComponent::class)
object SupabaseModule {

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient =
        createSupabaseClient(
            supabaseUrl = BuildConfig.SUPABASE_URL,
            supabaseKey = BuildConfig.API_KEY,
        ) {
            defaultSerializer = KotlinXSerializer(Json { ignoreUnknownKeys = true })
            install(Postgrest)
            install(Auth)
            install(Storage)
        }

    @Provides
    @Singleton
    // Postgrest = the "database tables" part of Supabase. Repositories inject this to read/write tables.
    fun providePostgrest(client: SupabaseClient): Postgrest = client.postgrest

    @Provides
    @Singleton
    fun provideAuth(client: SupabaseClient): Auth = client.auth

    @Provides
    @Singleton
    fun provideStorage(client: SupabaseClient): Storage = client.storage
}
