package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface GetProductDetailUseCase {
    fun getProductDetail(productId: String): Flow<ProductModel>
}

