package com.grocerystore.app.data.repository

import com.grocerystore.app.domain.models.MealModel

interface MealPlanRepository {
    suspend fun addMealToPlan(
        weekDay: String,
        name: String,
        ingredients: List<String>,
        mealType: String,
        mealImageUri: ByteArray
    )

    suspend fun retrieveMealByType(type: String, weekDayValue: String): List<MealModel>
    suspend fun removeMealFromPlan(id: String)
}