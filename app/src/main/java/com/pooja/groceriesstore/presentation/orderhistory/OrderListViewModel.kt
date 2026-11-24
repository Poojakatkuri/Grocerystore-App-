package com.pooja.groceriesstore.presentation.orderhistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pooja.groceriesstore.domain.models.OrderModel
import com.pooja.groceriesstore.domain.usecases.GetOrderListUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class OrderListViewModel @Inject constructor(
    private val getOrderListUseCase: GetOrderListUseCase
) : ViewModel() {

    private val _orderList = MutableStateFlow<List<OrderModel>>(listOf())
    val orderList: StateFlow<List<OrderModel>> = _orderList

    init {
        getOrderList()
    }

    private fun getOrderList() {
        viewModelScope.launch {
            when (val result = getOrderListUseCase(GetOrderListUseCase.Input())) {
                is GetOrderListUseCase.Output.Success -> {
                    _orderList.emit(result.data)
                }
                else -> {

                }
            }
        }

    }

}