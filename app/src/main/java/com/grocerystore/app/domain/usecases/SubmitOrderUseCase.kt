package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.OrderModel

interface SubmitOrderUseCase : SuspendUseCase<SubmitOrderUseCase.Input, SubmitOrderUseCase.Output> {
    class Input(val order: OrderModel)
    data class Output(val result: Boolean)
}
