package com.grocerystore.app.data.repository

import com.grocerystore.app.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

// FLOW step 5 (repository contract): the ONLY way the rest of the app gets product data.
// Screens and use cases depend on this interface, never on Room or Supabase directly.
// - functions returning Flow  -> read from the local database (live updates)
// - suspend refreshDatabase() -> download from the server and save into the local database
interface ProductRepository {
    val products: Flow<List<ProductModel>>
    fun getProductById(productId: String): Flow<ProductModel>
    fun getAllProductsByCategory(categoryId: String): Flow<List<ProductModel>>
    suspend fun refreshDatabase()
    suspend fun updateLineItemQuantityById(quantity: Int, id: Long)
    suspend fun removeLineItemById(id: Long)
    fun searchProductsListByName(name: String?): Flow<List<ProductModel>>
}
