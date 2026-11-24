package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.ProductRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.SearchProductUseCase
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