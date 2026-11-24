package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface SearchProductUseCase : SuspendUseCase<SearchProductUseCase.Input, SearchProductUseCase.Output> {
    class Input(val name: String? = null)
    class Output(val result: Flow<List<ProductModel>>)
}
