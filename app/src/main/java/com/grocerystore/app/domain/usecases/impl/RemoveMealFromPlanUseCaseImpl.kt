package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.MealPlanRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.RemoveMealFromPlanUseCase
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