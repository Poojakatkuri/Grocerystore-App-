package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.OrderRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.SubmitOrderUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SubmitOrderUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : SubmitOrderUseCase {
    override suspend fun invoke(input: SubmitOrderUseCase.Input): SubmitOrderUseCase.Output {
        return withContext(ioDispatcher) {
            val result = orderRepository.sendOrderToServer(input.order)
            SubmitOrderUseCase.Output(result)
        }
    }
}