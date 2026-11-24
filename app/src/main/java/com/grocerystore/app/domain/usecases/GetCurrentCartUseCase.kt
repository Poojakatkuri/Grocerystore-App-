package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.OrderModel
import kotlinx.coroutines.flow.Flow

interface GetCurrentCartUseCase :
    SuspendUseCase<GetCurrentCartUseCase.Input, GetCurrentCartUseCase.Output> {
    class Input
    data class Output(val result: Flow<OrderModel?>)
}
