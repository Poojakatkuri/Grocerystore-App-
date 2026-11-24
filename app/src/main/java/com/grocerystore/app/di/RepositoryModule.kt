package com.grocerystore.app.di

import com.grocerystore.app.data.repository.CategoryRepository
import com.grocerystore.app.data.repository.MealPlanRepository
import com.grocerystore.app.data.repository.OrderRepository
import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.data.repository.RecipeRepository
import com.grocerystore.app.data.repository.UserRepository
import com.grocerystore.app.data.repository.impl.CategoryRepositoryImpl
import com.grocerystore.app.data.repository.impl.MealPlanRepositoryImpl
import com.grocerystore.app.data.repository.impl.OrderRepositoryImpl
import com.grocerystore.app.data.repository.impl.ProductRepositoryImpl
import com.grocerystore.app.data.repository.impl.RecipeRepositoryImpl
import com.grocerystore.app.data.repository.impl.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// FLOW step 8 (wiring): tells Hilt which class to create when someone asks for a repository interface.
// @Singleton = one shared instance for the whole app.
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository

    @Binds
    @Singleton
    abstract fun bindOrderRepository(impl: OrderRepositoryImpl): OrderRepository

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(impl: RecipeRepositoryImpl): RecipeRepository

    @Binds
    @Singleton
    abstract fun bindMealPlanRepository(impl: MealPlanRepositoryImpl): MealPlanRepository
}
