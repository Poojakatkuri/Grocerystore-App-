package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.OrderRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.AddToCartUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
class AddToCartUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : AddToCartUseCase {
    override suspend fun invoke(input: AddToCartUseCase.Input): AddToCartUseCase.Output {
        // Run the database write on the IO thread (the dispatcher is injected so tests can replace it).
        withContext(ioDispatcher) {
            orderRepository.addLineItem(input.lineItem)
        }
        return AddToCartUseCase.Output()
    }
}