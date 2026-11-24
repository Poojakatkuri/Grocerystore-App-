package com.grocerystore.app.di

import com.grocerystore.app.domain.usecases.AddMealToPlanUseCase
import com.grocerystore.app.domain.usecases.AddToCartUseCase
import com.grocerystore.app.domain.usecases.CreateNewOrderUseCase
import com.grocerystore.app.domain.usecases.GetCategoriesListUseCase
import com.grocerystore.app.domain.usecases.GetCurrentCartUseCase
import com.grocerystore.app.domain.usecases.GetOrderListUseCase
import com.grocerystore.app.domain.usecases.GetProductDetailUseCase
import com.grocerystore.app.domain.usecases.GetProductsByCategoryUseCase
import com.grocerystore.app.domain.usecases.GetProductsListUseCase
import com.grocerystore.app.domain.usecases.GetProfileUseCase
import com.grocerystore.app.domain.usecases.RefreshAppDataUseCase
import com.grocerystore.app.domain.usecases.RemoveMealFromPlanUseCase
import com.grocerystore.app.domain.usecases.RetrieveMealByTypeUseCase
import com.grocerystore.app.domain.usecases.SearchProductUseCase
import com.grocerystore.app.domain.usecases.SignInUseCase
import com.grocerystore.app.domain.usecases.SignOutUseCase
import com.grocerystore.app.domain.usecases.SubmitOrderUseCase
import com.grocerystore.app.domain.usecases.UpdateCartItemUseCase
import com.grocerystore.app.domain.usecases.UpdateProfileUseCase
import com.grocerystore.app.domain.usecases.UserSettingsUseCase
import com.grocerystore.app.domain.usecases.impl.AddMealToPlanUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.AddToCartUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.CreateNewOrderUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.GetCategoriesListUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.GetCurrentCartUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.GetOrderListUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.GetProductDetailUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.GetProductsByCategoryUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.GetProductsListUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.GetProfileUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.RefreshAppDataUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.RemoveMealFromPlanUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.RetrieveMealByTypeUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.SearchProductUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.SignInUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.SignOutUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.SubmitOrderUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.UpdateCartItemUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.UpdateProfileUseCaseImpl
import com.grocerystore.app.domain.usecases.impl.UserSettingsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// FLOW step 8b (wiring): same idea for use cases, interface -> implementation.
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
