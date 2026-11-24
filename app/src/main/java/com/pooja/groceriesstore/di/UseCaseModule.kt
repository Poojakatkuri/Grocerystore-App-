package com.pooja.groceriesstore.di

import com.pooja.groceriesstore.domain.usecases.AddMealToPlanUseCase
import com.pooja.groceriesstore.domain.usecases.AddToCartUseCase
import com.pooja.groceriesstore.domain.usecases.CreateNewOrderUseCase
import com.pooja.groceriesstore.domain.usecases.GetCategoriesListUseCase
import com.pooja.groceriesstore.domain.usecases.GetCurrentCartUseCase
import com.pooja.groceriesstore.domain.usecases.GetOrderListUseCase
import com.pooja.groceriesstore.domain.usecases.GetProductDetailUseCase
import com.pooja.groceriesstore.domain.usecases.GetProductsByCategoryUseCase
import com.pooja.groceriesstore.domain.usecases.GetProductsListUseCase
import com.pooja.groceriesstore.domain.usecases.GetProfileUseCase
import com.pooja.groceriesstore.domain.usecases.RefreshAppDataUseCase
import com.pooja.groceriesstore.domain.usecases.RemoveMealFromPlanUseCase
import com.pooja.groceriesstore.domain.usecases.RetrieveMealByTypeUseCase
import com.pooja.groceriesstore.domain.usecases.SearchProductUseCase
import com.pooja.groceriesstore.domain.usecases.SignInUseCase
import com.pooja.groceriesstore.domain.usecases.SignOutUseCase
import com.pooja.groceriesstore.domain.usecases.SubmitOrderUseCase
import com.pooja.groceriesstore.domain.usecases.UpdateCartItemUseCase
import com.pooja.groceriesstore.domain.usecases.UpdateProfileUseCase
import com.pooja.groceriesstore.domain.usecases.UserSettingsUseCase
import com.pooja.groceriesstore.domain.usecases.impl.AddMealToPlanUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.AddToCartUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.CreateNewOrderUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.GetCategoriesListUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.GetCurrentCartUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.GetOrderListUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.GetProductDetailUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.GetProductsByCategoryUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.GetProductsListUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.GetProfileUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.RefreshAppDataUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.RemoveMealFromPlanUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.RetrieveMealByTypeUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.SearchProductUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.SignInUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.SignOutUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.SubmitOrderUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.UpdateCartItemUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.UpdateProfileUseCaseImpl
import com.pooja.groceriesstore.domain.usecases.impl.UserSettingsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Binds each use-case interface to its implementation.
 * Implementations declare their own dependencies with `@Inject constructor`.
 * Scoped as singletons to match the previous Koin `single { }` definitions.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds @Singleton
    abstract fun bindGetProductsListUseCase(impl: GetProductsListUseCaseImpl): GetProductsListUseCase

    @Binds @Singleton
    abstract fun bindGetProductDetailUseCase(impl: GetProductDetailUseCaseImpl): GetProductDetailUseCase

    @Binds @Singleton
    abstract fun bindUpdateCartItemUseCase(impl: UpdateCartItemUseCaseImpl): UpdateCartItemUseCase

    @Binds @Singleton
    abstract fun bindRefreshAppDataUseCase(impl: RefreshAppDataUseCaseImpl): RefreshAppDataUseCase

    @Binds @Singleton
    abstract fun bindSignInUseCase(impl: SignInUseCaseImpl): SignInUseCase

    @Binds @Singleton
    abstract fun bindSignOutUseCase(impl: SignOutUseCaseImpl): SignOutUseCase

    @Binds @Singleton
    abstract fun bindGetProfileUseCase(impl: GetProfileUseCaseImpl): GetProfileUseCase

    @Binds @Singleton
    abstract fun bindUserSettingsUseCase(impl: UserSettingsUseCaseImpl): UserSettingsUseCase

    @Binds @Singleton
    abstract fun bindGetCurrentCartUseCase(impl: GetCurrentCartUseCaseImpl): GetCurrentCartUseCase

    @Binds @Singleton
    abstract fun bindAddToCartUseCase(impl: AddToCartUseCaseImpl): AddToCartUseCase

    @Binds @Singleton
    abstract fun bindCreateNewOrderUseCase(impl: CreateNewOrderUseCaseImpl): CreateNewOrderUseCase

    @Binds @Singleton
    abstract fun bindGetProductsByCategoryUseCase(impl: GetProductsByCategoryUseCaseImpl): GetProductsByCategoryUseCase

    @Binds @Singleton
    abstract fun bindUpdateProfileUseCase(impl: UpdateProfileUseCaseImpl): UpdateProfileUseCase

    @Binds @Singleton
    abstract fun bindSubmitOrderUseCase(impl: SubmitOrderUseCaseImpl): SubmitOrderUseCase

    @Binds @Singleton
    abstract fun bindGetCategoriesListUseCase(impl: GetCategoriesListUseCaseImpl): GetCategoriesListUseCase

    @Binds @Singleton
    abstract fun bindSearchProductUseCase(impl: SearchProductUseCaseImpl): SearchProductUseCase

    @Binds @Singleton
    abstract fun bindGetOrderListUseCase(impl: GetOrderListUseCaseImpl): GetOrderListUseCase

    @Binds @Singleton
    abstract fun bindAddMealToPlanUseCase(impl: AddMealToPlanUseCaseImpl): AddMealToPlanUseCase

    @Binds @Singleton
    abstract fun bindRetrieveMealByTypeUseCase(impl: RetrieveMealByTypeUseCaseImpl): RetrieveMealByTypeUseCase

    @Binds @Singleton
    abstract fun bindRemoveMealFromPlanUseCase(impl: RemoveMealFromPlanUseCaseImpl): RemoveMealFromPlanUseCase
}
