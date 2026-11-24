package com.grocerystore.app.presentation.favourite

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier

import com.grocerystore.app.presentation.favourite.composables.RecipeItem
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun FavouriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavouriteViewModel = hiltViewModel()
) {
    val recipes = viewModel.recipesList.observeAsState().value
    LazyColumn {
        items(recipes!!) { item ->
            RecipeItem(recipe = item)

        }
    }
}