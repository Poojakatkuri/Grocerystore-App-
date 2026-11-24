package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.data.database.entities.LineItem

interface AddToCartUseCase: SuspendUseCase<AddToCartUseCase.Input, AddToCartUseCase.Output> {
    class Input (val lineItem: LineItem)

    class Output
}
