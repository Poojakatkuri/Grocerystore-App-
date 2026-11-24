package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

// FLOW step 9 (use case / "read" action): one small class per action the app can perform.
// ViewModels call use cases; use cases call repositories.
interface GetProductDetailUseCase {
    fun getProductDetail(productId: String): Flow<ProductModel>
}

