package com.grocerystore.app.presentation.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grocerystore.app.domain.models.UserModel
import com.grocerystore.app.domain.usecases.GetProfileUseCase
import com.grocerystore.app.domain.usecases.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val signOutUseCase: SignOutUseCase
) : ViewModel() {

    private val _user: MutableStateFlow<UserModel?> = MutableStateFlow(null)
    val user: MutableStateFlow<UserModel?>
        get() = _user

    init {
        getCurrentUser()
    }

    private fun getCurrentUser() {
        viewModelScope.launch(Dispatchers.IO) {
            getProfileUseCase(GetProfileUseCase.Input()).result.collect {
                _user.value = it
            }
        }
    }

    fun signOut() {
        viewModelScope.launch(Dispatchers.IO) {
            signOutUseCase(SignOutUseCase.Input())
        }
    }
}
