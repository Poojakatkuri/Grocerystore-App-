package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.CategoryRepository
import com.pooja.groceriesstore.domain.usecases.GetCategoriesListUseCase
import javax.inject.Inject

class GetCategoriesListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoriesListUseCase {
    override suspend fun invoke(input: GetCategoriesListUseCase.Input): GetCategoriesListUseCase.Output {
        val result = categoryRepository.getFromLocal()
        return GetCategoriesListUseCase.Output(result)
    }
}