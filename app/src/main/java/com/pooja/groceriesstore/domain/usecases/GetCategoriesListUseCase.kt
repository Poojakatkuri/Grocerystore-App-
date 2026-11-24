package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.domain.models.CategoryModel
import kotlinx.coroutines.flow.Flow

interface GetCategoriesListUseCase :
    SuspendUseCase<GetCategoriesListUseCase.Input, GetCategoriesListUseCase.Output> {
    class Input

    class Output(val result: Flow<List<CategoryModel>>)
}
