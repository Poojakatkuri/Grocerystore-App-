package com.pooja.groceriesstore.data.repository

import com.pooja.groceriesstore.domain.models.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun refreshDatabase()
    fun getFromLocal(): Flow<List<CategoryModel>>
}
