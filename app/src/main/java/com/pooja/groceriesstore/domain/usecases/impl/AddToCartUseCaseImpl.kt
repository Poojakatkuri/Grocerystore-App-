package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.OrderRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.AddToCartUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
class AddToCartUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : AddToCartUseCase {
    override suspend fun invoke(input: AddToCartUseCase.Input): AddToCartUseCase.Output {
        withContext(ioDispatcher) {
            orderRepository.addLineItem(input.lineItem)
        }
        return AddToCartUseCase.Output()
    }
}