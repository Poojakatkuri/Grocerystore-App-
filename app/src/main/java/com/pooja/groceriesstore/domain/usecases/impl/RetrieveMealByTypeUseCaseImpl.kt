package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.MealPlanRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.RetrieveMealByTypeUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RetrieveMealByTypeUseCaseImpl @Inject constructor(
    private val mealPlanRepository: MealPlanRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RetrieveMealByTypeUseCase {
    override suspend fun invoke(input: RetrieveMealByTypeUseCase.Input): RetrieveMealByTypeUseCase.Output {
        return withContext(ioDispatcher) {
            try {
                val result = mealPlanRepository.retrieveMealByType(
                    type = input.mealType.value,
                    weekDayValue = input.dayValue.dayValue
                )
                RetrieveMealByTypeUseCase.Output.Success(data = result)
            } catch (e: Exception) {
                RetrieveMealByTypeUseCase.Output.Failure
            }
        }
    }
}