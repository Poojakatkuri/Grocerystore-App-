package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.CategoryRepository
import com.grocerystore.app.domain.usecases.GetCategoriesListUseCase
import javax.inject.Inject

class GetCategoriesListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoriesListUseCase {
    override suspend fun invoke(input: GetCategoriesListUseCase.Input): GetCategoriesListUseCase.Output {
        val result = categoryRepository.getFromLocal()
        return GetCategoriesListUseCase.Output(result)
    }
}