package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.CategoryRepository
import com.pooja.groceriesstore.data.repository.ProductRepository
import com.pooja.groceriesstore.data.repository.RecipeRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.RefreshAppDataUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RefreshAppDataUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val recipeRepository: RecipeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RefreshAppDataUseCase {
    override suspend fun invoke(input: Unit) {
        withContext(ioDispatcher) {
            categoryRepository.refreshDatabase()
            productRepository.refreshDatabase()
            recipeRepository.refreshDatabase()
        }
    }
}
