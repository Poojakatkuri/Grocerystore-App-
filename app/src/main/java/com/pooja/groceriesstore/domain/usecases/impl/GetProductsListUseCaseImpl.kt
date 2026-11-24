package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.ProductRepository
import com.pooja.groceriesstore.domain.usecases.GetProductsListUseCase
import javax.inject.Inject

class GetProductsListUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductsListUseCase {
    override fun invoke(input: GetProductsListUseCase.Input): GetProductsListUseCase.Output {
        val result = productRepository.products
        return GetProductsListUseCase.Output(result)
    }
}
