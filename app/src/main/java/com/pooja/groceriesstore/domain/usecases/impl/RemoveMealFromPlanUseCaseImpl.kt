package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.MealPlanRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.RemoveMealFromPlanUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RemoveMealFromPlanUseCaseImpl @Inject constructor(
    private val mealPlanRepository: MealPlanRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RemoveMealFromPlanUseCase {
    override suspend fun invoke(input: RemoveMealFromPlanUseCase.Input): RemoveMealFromPlanUseCase.Output {
        return withContext(ioDispatcher) {
            try {
                mealPlanRepository.removeMealFromPlan(input.id)
                RemoveMealFromPlanUseCase.Output.Success
            } catch (e: Exception) {
                RemoveMealFromPlanUseCase.Output.Failure
            }
        }
    }
}