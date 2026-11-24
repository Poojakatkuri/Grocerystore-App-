package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.domain.usecases.GetProductsListUseCase
import javax.inject.Inject

class GetProductsListUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductsListUseCase {
    override fun invoke(input: GetProductsListUseCase.Input): GetProductsListUseCase.Output {
        val result = productRepository.products
        return GetProductsListUseCase.Output(result)
    }
}
