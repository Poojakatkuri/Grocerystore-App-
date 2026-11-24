package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.OrderModel

interface GetOrderListUseCase : SuspendUseCase<GetOrderListUseCase.Input, GetOrderListUseCase.Output> {
    class Input
    sealed class Output {
        class Success(val data: List<OrderModel>) : Output()
        object Failure : Output()
    }
}
