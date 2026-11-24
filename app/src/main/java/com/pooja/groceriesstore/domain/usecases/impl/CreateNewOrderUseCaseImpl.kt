package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.OrderRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.CreateNewOrderUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CreateNewOrderUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : CreateNewOrderUseCase {
    override suspend fun invoke(input: CreateNewOrderUseCase.Input): CreateNewOrderUseCase.Output {
        return withContext(ioDispatcher) {
            val result = orderRepository.createOrUpdate(input.order)
            CreateNewOrderUseCase.Output(result)
        }
    }
}