package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.domain.models.MealModel
import com.pooja.groceriesstore.presentation.mealplanning.overview.state.MealType
import com.pooja.groceriesstore.presentation.mealplanning.overview.state.WeekDayValue

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