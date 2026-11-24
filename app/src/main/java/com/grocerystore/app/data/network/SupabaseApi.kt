package com.grocerystore.app.data.network

import com.grocerystore.app.data.network.dto.CategoriesDto
import com.grocerystore.app.data.network.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Query

// FLOW step 2 (network "endpoints"): Retrofit interface for Supabase's REST API.
// Every Supabase table is available at <SUPABASE_URL>/rest/v1/<table_name>.
// "select=*" asks for all columns. Retrofit turns each function into an HTTP request and
// converts the JSON response into DTOs (step 3). Hilt creates it in NetworkModule (step 1).
interface SupabaseApi {

    // GET <SUPABASE_URL>/rest/v1/products?select=*
    @GET("rest/v1/products")
    suspend fun getProducts(@Query("select") select: String = "*"): List<ProductDto>

    // GET <SUPABASE_URL>/rest/v1/categories?select=*
    @GET("rest/v1/categories")
    suspend fun getCategories(@Query("select") select: String = "*"): List<CategoriesDto>
}
