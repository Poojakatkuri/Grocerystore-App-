package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.SearchProductUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SearchProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : SearchProductUseCase {
    override suspend fun invoke(input: SearchProductUseCase.Input): SearchProductUseCase.Output {
        return withContext(ioDispatcher) {
            val result = productRepository.searchProductsListByName(input.name)
            SearchProductUseCase.Output(result)
        }
    }
}