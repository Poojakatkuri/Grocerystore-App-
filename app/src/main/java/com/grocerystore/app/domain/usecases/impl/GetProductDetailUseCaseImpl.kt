package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.domain.usecases.GetProductDetailUseCase
import javax.inject.Inject

class GetProductDetailUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
) : GetProductDetailUseCase {
    override fun getProductDetail(productId: String) = productRepository.getProductById(productId)
}

