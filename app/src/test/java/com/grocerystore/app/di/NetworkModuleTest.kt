package com.grocerystore.app.di

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Checks the Retrofit Supabase client without a real server: a fake interceptor records the
 * request Retrofit builds and answers with canned JSON.
 */
class NetworkModuleTest {

    private var lastRequest: Request? = null

    private fun fakeServer(json: String) = Interceptor { chain ->
        lastRequest = chain.request()
        Response.Builder()
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .code(200)
            .message("OK")
            .body(json.toResponseBody("application/json".toMediaType()))
            .build()
    }

    private fun api(json: String, userToken: String? = null) = NetworkModule.createSupabaseApi(
        baseUrl = "https://project.supabase.co",
        apiKey = "anon-key",
        userAccessToken = { userToken },
        okHttpBuilder = OkHttpClient.Builder().addInterceptor(fakeServer(json)),
    )

    @Test
    fun getProducts_buildsRestRequest_andParsesDtos() = runBlocking {
        val products = api(
            """[{"id":"p1","name":"Apple","description":"Fresh","price":1.5,"image":"https://img/apple.jpg",
                "category":"c1","nutrition":"Vitamins","extra_column":"ignored"}]"""
        ).getProducts()

        val request = lastRequest!!
        assertEquals("https://project.supabase.co/rest/v1/products?select=*", request.url.toString())
        assertEquals("anon-key", request.header("apikey"))
        assertEquals("Bearer anon-key", request.header("Authorization"))
        assertEquals(1, products.size)
        assertEquals("p1", products[0].productId)
        assertEquals(1.5, products[0].price, 0.0)
    }

    @Test
    fun getCategories_usesLoggedInUserToken_whenAvailable() = runBlocking {
        val categories = api(
            """[{"id":"c1","name":"Fruits","image":"https://img/fruits.jpg","_id":1}]""",
            userToken = "user-jwt",
        ).getCategories()

        val request = lastRequest!!
        assertEquals("/rest/v1/categories", request.url.encodedPath)
        assertEquals("anon-key", request.header("apikey"))
        assertEquals("Bearer user-jwt", request.header("Authorization"))
        assertEquals("Fruits", categories.single().name)
    }

    @Test
    fun supabaseBaseUrl_acceptsUrlsWithOrWithoutScheme_andFallsBackWhenInvalid() {
        assertEquals("https://abc.supabase.co/", NetworkModule.supabaseBaseUrl("abc.supabase.co").toString())
        assertEquals("https://abc.supabase.co/", NetworkModule.supabaseBaseUrl("https://abc.supabase.co/").toString())
        assertEquals(
            "https://supabase-url-not-configured.invalid/",
            NetworkModule.supabaseBaseUrl("").toString()
        )
    }
}
