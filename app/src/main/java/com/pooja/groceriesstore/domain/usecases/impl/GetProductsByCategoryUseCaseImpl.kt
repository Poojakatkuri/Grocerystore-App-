package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.ProductRepository
import com.pooja.groceriesstore.domain.usecases.GetProductsByCategoryUseCase
import javax.inject.Inject

class GetProductsByCategoryUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductsByCategoryUseCase {
    override fun invoke(input: GetProductsByCategoryUseCase.Input): GetProductsByCategoryUseCase.Output {
        val result = productRepository.getAllProductsByCategory(input.categoryId)
        return GetProductsByCategoryUseCase.Output(result)
    }
}
