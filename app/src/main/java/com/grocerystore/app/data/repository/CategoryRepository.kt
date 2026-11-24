package com.grocerystore.app.data.repository

import com.grocerystore.app.domain.models.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun refreshDatabase()
    fun getFromLocal(): Flow<List<CategoryModel>>
}
