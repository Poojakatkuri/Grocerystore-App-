package com.grocerystore.app.data.repository.impl

import com.grocerystore.app.data.database.dao.LineItemDao
import com.grocerystore.app.data.database.dao.ProductDao
import com.grocerystore.app.data.database.entities.Product
import com.grocerystore.app.data.database.entities.asDomainModel
import com.grocerystore.app.data.network.SupabaseApi
import com.grocerystore.app.data.network.dto.ProductDto
import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.domain.models.ProductModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

// FLOW step 6 (repository implementation): knows BOTH data sources.
// @Inject constructor = Hilt builds this class and passes the DAOs (local) and SupabaseApi (remote, Retrofit).
// RepositoryModule binds ProductRepository -> ProductRepositoryImpl.
class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val lineItemDao: LineItemDao,
    private val supabaseApi: SupabaseApi
) : ProductRepository {

    override val products: Flow<List<ProductModel>> =
        productDao.getAll().map {
            it.asDomainModel()
        }

    // FLOW step 6a (SERVER -> PHONE DB): download the "products" table with Retrofit, convert ProductDto -> Product
    // (Room entity) and save it. The screen never reads the server directly; it reads Room (offline-first).
    override suspend fun refreshDatabase() {
        try {
            val result: List<ProductDto> = supabaseApi.getProducts()
            val products = result.map { it.asEntity() }
            productDao.insertAll(products)
        } catch (e: Exception) {
            Timber.e(e.message)
        }
    }

    override suspend fun updateLineItemQuantityById(quantity: Int, id: Long) {
        try {
            lineItemDao.updateQuantityById(quantity, id)
        } catch (e: Exception) {
            Timber.e(e.message)
        }
    }

    override suspend fun removeLineItemById(id: Long) {
        try {
            lineItemDao.removeLineItemById(id)
        } catch (e: Exception) {
            Timber.e(e.message)
        }
    }

    override fun searchProductsListByName(name: String?) =
        productDao.searchProductByName(name).map { it.asDomainModel() }

    override fun getAllProductsByCategory(categoryId: String): Flow<List<ProductModel>> {
        return try {
            productDao.getAllByCategory(categoryId).map {
                it.asDomainModel()
            }
        } catch (e: Exception) {
            Timber.e(e.message)
            flow {}
        }
    }

    // FLOW step 6b (PHONE DB -> APP): read one product from Room as a Flow and convert
    // Product (entity) -> ProductModel (domain model). The Flow emits again whenever that row changes.
    override fun getProductById(productId: String): Flow<ProductModel> {
        try {
            val productFlow = productDao.getById(productId)
            return productFlow.map {
                it.asDomainModel()
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
        return flow {}
    }

    private fun ProductDto.asEntity(): Product = Product(
        id = productId,
        name = name,
        nutrition = nutrition,
        description = description,
        image = image,
        price = price,
        category = category,
    )

}
