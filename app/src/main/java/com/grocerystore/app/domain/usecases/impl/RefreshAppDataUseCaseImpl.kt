package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.CategoryRepository
import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.data.repository.RecipeRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.RefreshAppDataUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RefreshAppDataUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val recipeRepository: RecipeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RefreshAppDataUseCase {
    // FLOW step 4b: asks every repository to download fresh data, on the IO (background) thread.
    override suspend fun invoke(input: Unit) {
        withContext(ioDispatcher) {
            categoryRepository.refreshDatabase()
            productRepository.refreshDatabase()
            recipeRepository.refreshDatabase()
        }
    }
}
