package com.pooja.groceriesstore.domain.usecases

import com.pooja.groceriesstore.domain.models.LineItemModel
import com.pooja.groceriesstore.domain.models.OrderModel
import kotlinx.coroutines.flow.Flow

interface UpdateCartItemUseCase {
    suspend fun updateLineItem(lineItemModel: LineItemModel)
    suspend fun removeLineItem(lineItemModel: LineItemModel)
    fun getCurrentCart(): Flow<OrderModel?>
}
