package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.LineItemModel
import com.grocerystore.app.domain.models.OrderModel
import kotlinx.coroutines.flow.Flow

interface UpdateCartItemUseCase {
    suspend fun updateLineItem(lineItemModel: LineItemModel)
    suspend fun removeLineItem(lineItemModel: LineItemModel)
    fun getCurrentCart(): Flow<OrderModel?>
}
