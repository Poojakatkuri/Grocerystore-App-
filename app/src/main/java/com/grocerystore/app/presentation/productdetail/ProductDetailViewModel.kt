package com.grocerystore.app.presentation.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grocerystore.app.data.database.entities.LineItem
import com.grocerystore.app.data.database.entities.Order
import com.grocerystore.app.data.repository.OrderRepository
import com.grocerystore.app.domain.models.OrderModel
import com.grocerystore.app.domain.usecases.GetProductDetailUseCase
import com.grocerystore.app.utilities.OrderStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// FLOW step 12 (ViewModel): holds the screen state and handles user actions.
// @HiltViewModel + @Inject constructor = Hilt creates it and passes the use case / repository.
@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getProductDetailUseCase: GetProductDetailUseCase,
    private val orderRepository: OrderRepository
) : ViewModel() {

    // Read the "id" navigation argument (sent from ShopFragment in step 10).
    private val args = ProductDetailFragmentArgs.fromSavedStateHandle(savedStateHandle)

    // STATE: Flow from the use case -> StateFlow the screen can observe.
    // Starts as null (not loaded yet); stops listening 5s after the screen goes away.
    val product = getProductDetailUseCase.getProductDetail(args.id).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )

    var currentCart: StateFlow<OrderModel?> =
        orderRepository.getOneOrderByStatus(OrderStatus.IN_CART)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    // STATE: private writable _quantity, public read-only quantity. Only the ViewModel changes it.
    private val _quantity = MutableStateFlow(1)
    val quantity: StateFlow<Int>
        get() = _quantity

    init {
        viewModelScope.launch {
            currentCart.collect {}
        }
    }

    // ACTION: called when the user taps "Add to Basket". Saves a LineItem into the local cart (Room).
    // Creates a new IN_CART order first if there is none. Sent to the server only at checkout.
    // Note: ShopViewModel does this through AddToCartUseCase, which is the cleaner pattern.
    fun addToCart() {
        viewModelScope.launch {
            val subtotal = product.value?.price?.times(_quantity.value) ?: 0.0
            if (currentCart.value != null) {
                // Add to cart
                val cartId = currentCart.value!!.id
                val lineItem = LineItem(
                    productId = product.value!!.id,
                    orderId = cartId,
                    quantity = _quantity.value,
                    subtotal = subtotal
                )
                orderRepository.addLineItem(lineItem)
            } else {
                val id = UUID.randomUUID().toString()
                val newOrder = Order(
                    id = id,
                    status = OrderStatus.IN_CART.value,
                    address = ""
                )
                orderRepository.createOrUpdate(newOrder)
                val lineItem = LineItem(
                    productId = product.value!!.id,
                    orderId = id,
                    quantity = _quantity.value,
                    subtotal = subtotal
                )
                orderRepository.addLineItem(lineItem)
            }
        }
    }

    // ACTION: updating the StateFlow makes Compose redraw the quantity text automatically.
    fun increaseQty() {
        _quantity.value++
    }

    fun decreaseQty() {
        if (_quantity.value <= 1) return
        _quantity.value--
    }

}
