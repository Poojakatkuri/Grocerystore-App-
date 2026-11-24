package com.grocerystore.app.data.repository

import com.grocerystore.app.data.database.entities.LineItem
import com.grocerystore.app.data.database.entities.Order
import com.grocerystore.app.domain.models.OrderModel
import com.grocerystore.app.utilities.OrderStatus
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun createOrUpdate(order: Order)
    suspend fun addLineItem(lineItem: LineItem)
    fun getOneOrderByStatus(status: OrderStatus): Flow<OrderModel?>
    suspend fun sendOrderToServer(order: OrderModel): Boolean

    suspend fun getOrders(): List<OrderModel>
}
