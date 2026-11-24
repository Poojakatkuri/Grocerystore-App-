package com.grocerystore.app.domain.usecases

import com.grocerystore.app.data.database.entities.Order

interface CreateNewOrderUseCase :
    SuspendUseCase<CreateNewOrderUseCase.Input, CreateNewOrderUseCase.Output> {
    class Input(val order: Order)

    class Output(result: Unit)
}
