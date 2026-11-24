package com.pooja.groceriesstore.data.repository.impl

import com.pooja.groceriesstore.data.database.dao.CategoryDao
import com.pooja.groceriesstore.data.database.entities.Category
import com.pooja.groceriesstore.data.database.entities.asDomainModel
import com.pooja.groceriesstore.data.network.RemoteTable
import com.pooja.groceriesstore.data.network.dto.CategoriesDto
import com.pooja.groceriesstore.data.repository.CategoryRepository
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import timber.log.Timber

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val supabasePostgrest: Postgrest
) :
    CategoryRepository {

    override suspend fun refreshDatabase() {
        try {
            val result = supabasePostgrest[RemoteTable.Categories.tableName]
                .select()
            val res = result.decodeList<CategoriesDto>()
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
