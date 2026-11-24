package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.OrderRepository
import com.pooja.groceriesstore.data.repository.ProductRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.models.LineItemModel
import com.pooja.groceriesstore.domain.models.OrderModel
import com.pooja.groceriesstore.domain.usecases.UpdateCartItemUseCase
import com.pooja.groceriesstore.utilities.OrderStatus
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UpdateCartItemUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UpdateCartItemUseCase {
    override suspend fun updateLineItem(lineItemModel: LineItemModel) {
        // Check if the quantity is valid
        if (lineItemModel.quantity == null || lineItemModel.quantity!! <= 0) {
            throw IllegalArgumentException("Quantity must be greater than zero.")
        }

        // Check if the ID is valid
        if (lineItemModel.id == null) {
            throw IllegalArgumentException("Line item ID cannot be null.")
        }

        withContext(ioDispatcher) {
            if (lineItemModel.quantity != null && lineItemModel.id != null) {
                productRepository.updateLineItemQuantityById(
                    lineItemModel.quantity!!,
                    lineItemModel.id!!
                )
            }
        }
    }

    override suspend fun removeLineItem(lineItemModel: LineItemModel) {
        // Check if the ID is valid
        if (lineItemModel.id == null) {
            throw IllegalArgumentException("Line item ID cannot be null.")
        }

        withContext(ioDispatcher) {
            if (lineItemModel.id != null) {
                productRepository.removeLineItemById(lineItemModel.id!!)
            }
        }
    }

    override fun getCurrentCart(): Flow<OrderModel?> {
        return orderRepository.getOneOrderByStatus(OrderStatus.IN_CART)
    }
}
