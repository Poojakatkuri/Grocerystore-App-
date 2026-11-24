package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.MealModel
import com.grocerystore.app.presentation.mealplanning.overview.state.MealType
import com.grocerystore.app.presentation.mealplanning.overview.state.WeekDayValue

interface RetrieveMealByTypeUseCase :
    SuspendUseCase<RetrieveMealByTypeUseCase.Input, RetrieveMealByTypeUseCase.Output> {
    class Input(
        val dayValue: WeekDayValue,
        val mealType: MealType,
    )

    sealed class Output {
        class Success(val data: List<MealModel>) : Output()
        data object Failure : Output()
    }
}