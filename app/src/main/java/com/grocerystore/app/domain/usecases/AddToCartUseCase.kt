package com.grocerystore.app.domain.usecases

import com.grocerystore.app.data.database.entities.LineItem

// FLOW step 9b (use case / "write" action): typed Input -> Output contract.
// Called like a function thanks to "operator fun invoke": addToCartUseCase(Input(lineItem)).
interface AddToCartUseCase: SuspendUseCase<AddToCartUseCase.Input, AddToCartUseCase.Output> {
    class Input (val lineItem: LineItem)

    class Output
}
