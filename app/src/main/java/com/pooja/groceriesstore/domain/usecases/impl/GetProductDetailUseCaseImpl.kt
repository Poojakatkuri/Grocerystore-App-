package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.ProductRepository
import com.pooja.groceriesstore.domain.usecases.GetProductDetailUseCase
import javax.inject.Inject

class GetProductDetailUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
) : GetProductDetailUseCase {
    override fun getProductDetail(productId: String) = productRepository.getProductById(productId)
}

