package com.pooja.groceriesstore.data.repository.impl

import com.pooja.groceriesstore.data.database.dao.RecipeDao
import com.pooja.groceriesstore.data.database.entities.asDomainModel
import com.pooja.groceriesstore.data.network.Api
import com.pooja.groceriesstore.data.network.dto.asEntity
import com.pooja.groceriesstore.data.repository.RecipeRepository
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
