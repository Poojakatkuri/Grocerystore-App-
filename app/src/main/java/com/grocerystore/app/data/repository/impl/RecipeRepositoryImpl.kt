package com.grocerystore.app.data.repository.impl

import com.grocerystore.app.data.database.dao.RecipeDao
import com.grocerystore.app.data.database.entities.asDomainModel
import com.grocerystore.app.data.network.Api
import com.grocerystore.app.data.network.dto.asEntity
import com.grocerystore.app.data.repository.RecipeRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import timber.log.Timber

class RecipeRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao
) : RecipeRepository {
    override suspend fun refreshDatabase() {
        try {
            val getRecipeDeferred = Api.retrofitService.getRecipesList()
            val listResult = getRecipeDeferred.await().recipesList.asEntity()
            recipeDao.insertAll(listResult)
        } catch (e: Exception) {
            Timber.e(e.message)
        }
    }

    override fun getFromLocal() = recipeDao.getAll().map { it.asDomainModel() }
}
