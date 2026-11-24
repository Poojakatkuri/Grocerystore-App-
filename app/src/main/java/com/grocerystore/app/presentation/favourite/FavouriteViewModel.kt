package com.grocerystore.app.presentation.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.grocerystore.app.data.repository.RecipeRepository
import com.grocerystore.app.domain.models.RecipeModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class FavouriteViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    private var _recipesList: MutableLiveData<List<RecipeModel>> =
        recipeRepository.getFromLocal().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        ).asLiveData() as MutableLiveData<List<RecipeModel>>
    val recipesList: LiveData<List<RecipeModel>> = _recipesList

}
