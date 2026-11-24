package com.pooja.groceriesstore.di

import com.pooja.groceriesstore.data.repository.CategoryRepository
import com.pooja.groceriesstore.data.repository.MealPlanRepository
import com.pooja.groceriesstore.data.repository.OrderRepository
import com.pooja.groceriesstore.data.repository.ProductRepository
import com.pooja.groceriesstore.data.repository.RecipeRepository
import com.pooja.groceriesstore.data.repository.UserRepository
import com.pooja.groceriesstore.data.repository.impl.CategoryRepositoryImpl
import com.pooja.groceriesstore.data.repository.impl.MealPlanRepositoryImpl
import com.pooja.groceriesstore.data.repository.impl.OrderRepositoryImpl
import com.pooja.groceriesstore.data.repository.impl.ProductRepositoryImpl
import com.pooja.groceriesstore.data.repository.impl.RecipeRepositoryImpl
import com.pooja.groceriesstore.data.repository.impl.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
