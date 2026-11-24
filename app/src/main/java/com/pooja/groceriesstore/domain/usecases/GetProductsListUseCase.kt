package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface GetProductsListUseCase: UseCase<GetProductsListUseCase.Input, GetProductsListUseCase.Output> {
    class Input
    class Output(val result: Flow<List<ProductModel>>)
}
