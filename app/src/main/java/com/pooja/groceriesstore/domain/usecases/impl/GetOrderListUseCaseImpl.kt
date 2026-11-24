package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.OrderRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.GetOrderListUseCase
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