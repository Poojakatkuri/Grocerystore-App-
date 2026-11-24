package com.grocerystore.app.presentation.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

// FLOW step 11 (screen host): a thin Fragment that only hosts a Compose screen.
// @AndroidEntryPoint lets Hilt create ViewModels for screens inside this Fragment.
// The Fragment passes navigation (go back) into the screen as a lambda.
@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ProductDetailScreen(
                    onNavigateBack = {
                        findNavController().navigateUp()
                    }
                )
            }
        }
    }
}
