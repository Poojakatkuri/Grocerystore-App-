package com.grocerystore.app.data.repository

import com.grocerystore.app.domain.models.RecipeModel
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun refreshDatabase()
    fun getFromLocal(): Flow<List<RecipeModel>>
}
