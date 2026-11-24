package com.grocerystore.app.data.repository.impl

import com.grocerystore.app.data.database.dao.CategoryDao
import com.grocerystore.app.data.database.entities.Category
import com.grocerystore.app.data.database.entities.asDomainModel
import com.grocerystore.app.data.network.SupabaseApi
import com.grocerystore.app.data.network.dto.CategoriesDto
import com.grocerystore.app.data.repository.CategoryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import timber.log.Timber

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val supabaseApi: SupabaseApi
) :
    CategoryRepository {

    override suspend fun refreshDatabase() {
        try {
            // Download the "categories" table with Retrofit (see SupabaseApi), then save it into Room.
            val res: List<CategoriesDto> = supabaseApi.getCategories()
            val categories = res.map { it.asEntity() }
            categoryDao.insertAll(categories)
        } catch (e: Exception) {
            Timber.e(e.message)
        }
    }

    override fun getFromLocal() = categoryDao.getAll().map { it.asDomainModel() }

    private fun CategoriesDto.asEntity(): Category = Category(
        id = id,
        name = name,
        image = image,
    )

}
