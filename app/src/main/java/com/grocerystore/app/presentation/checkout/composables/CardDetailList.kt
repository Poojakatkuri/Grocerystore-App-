package com.grocerystore.app.presentation.checkout.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.grocerystore.app.domain.models.LineItemModel
import com.grocerystore.app.presentation.checkout.composables.CartItem

@Composable
fun CartDetailList(
    modifier: Modifier = Modifier,
    cartItems: List<LineItemModel>
) {
    LazyColumn(modifier = modifier.padding(top = 8.dp)) {
        items(cartItems) { cartItem ->
            CartItem(lineItem = cartItem) {
                // onDeleteClick ()
            }
        }
    }
}