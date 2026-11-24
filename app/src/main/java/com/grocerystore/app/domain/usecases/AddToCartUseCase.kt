package com.grocerystore.app.domain.usecases

import com.grocerystore.app.data.database.entities.LineItem

interface AddToCartUseCase: SuspendUseCase<AddToCartUseCase.Input, AddToCartUseCase.Output> {
    class Input (val lineItem: LineItem)

    class Output
}
