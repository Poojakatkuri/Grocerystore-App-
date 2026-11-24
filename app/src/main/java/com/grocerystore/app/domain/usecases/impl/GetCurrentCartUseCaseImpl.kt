package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.OrderRepository
import com.grocerystore.app.domain.usecases.GetCurrentCartUseCase
import com.grocerystore.app.utilities.OrderStatus
import javax.inject.Inject

class GetCurrentCartUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
) : GetCurrentCartUseCase {

    override suspend fun invoke(input: GetCurrentCartUseCase.Input): GetCurrentCartUseCase.Output {
        val res = orderRepository.getOneOrderByStatus(OrderStatus.IN_CART)
        return GetCurrentCartUseCase.Output(res)

    }
}