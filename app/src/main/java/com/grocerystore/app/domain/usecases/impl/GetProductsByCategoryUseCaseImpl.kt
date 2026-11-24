package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.domain.usecases.GetProductsByCategoryUseCase
import javax.inject.Inject

class GetProductsByCategoryUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductsByCategoryUseCase {
    override fun invoke(input: GetProductsByCategoryUseCase.Input): GetProductsByCategoryUseCase.Output {
        val result = productRepository.getAllProductsByCategory(input.categoryId)
        return GetProductsByCategoryUseCase.Output(result)
    }
}
