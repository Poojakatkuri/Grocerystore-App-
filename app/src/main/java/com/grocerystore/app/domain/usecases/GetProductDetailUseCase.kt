package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface GetProductDetailUseCase {
    fun getProductDetail(productId: String): Flow<ProductModel>
}

