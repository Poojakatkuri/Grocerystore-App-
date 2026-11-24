package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.OrderRepository
import com.pooja.groceriesstore.domain.usecases.GetCurrentCartUseCase
import com.pooja.groceriesstore.utilities.OrderStatus
import javax.inject.Inject

class GetCurrentCartUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
) : GetCurrentCartUseCase {

    override suspend fun invoke(input: GetCurrentCartUseCase.Input): GetCurrentCartUseCase.Output {
        val res = orderRepository.getOneOrderByStatus(OrderStatus.IN_CART)
        return GetCurrentCartUseCase.Output(res)

    }
}