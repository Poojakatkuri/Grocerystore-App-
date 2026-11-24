package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.domain.models.OrderModel

interface SubmitOrderUseCase : SuspendUseCase<SubmitOrderUseCase.Input, SubmitOrderUseCase.Output> {
    class Input(val order: OrderModel)
    data class Output(val result: Boolean)
}
