package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface GetProductsListUseCase: UseCase<GetProductsListUseCase.Input, GetProductsListUseCase.Output> {
    class Input
    class Output(val result: Flow<List<ProductModel>>)
}
