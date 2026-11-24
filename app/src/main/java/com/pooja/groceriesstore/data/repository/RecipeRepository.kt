package com.pooja.groceriesstore.data.repository

import com.pooja.groceriesstore.domain.models.RecipeModel
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun refreshDatabase()
    fun getFromLocal(): Flow<List<RecipeModel>>
}
