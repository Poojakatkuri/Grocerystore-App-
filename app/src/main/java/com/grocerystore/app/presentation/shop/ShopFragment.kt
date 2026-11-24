package com.grocerystore.app.presentation.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ShopScreen(
                    navigateToProductDetails = { id -> navigateToProductDetail(id)
                    }
                )
            }
        }
    }

    // FLOW step 10 (navigation): the Shop screen only calls a lambda with the product id;
    // the Fragment decides where to go. Safe Args generates ShopFragmentDirections from navigation.xml
    // and passes "id" as an argument to ProductDetailFragment.
    private fun navigateToProductDetail(productId: String) {
        val direction = ShopFragmentDirections.actionShopFragmentToProductDetailFragment(
            productId
        )
        findNavController().navigate(direction)
    }

}
