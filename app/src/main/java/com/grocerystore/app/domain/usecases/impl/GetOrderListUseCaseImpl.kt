package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.OrderRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.GetOrderListUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetOrderListUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : GetOrderListUseCase {
    override suspend fun invoke(input: GetOrderListUseCase.Input): GetOrderListUseCase.Output {
        return withContext(ioDispatcher) {
            val result = orderRepository.getOrders()
            GetOrderListUseCase.Output.Success(data = result)
        }
    }
}