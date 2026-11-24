package com.grocerystore.app.presentation.updateprofile

import com.grocerystore.app.domain.models.UserModel

data class UpdateProfileUiState(
    val user: UserModel? = null,
    val isLoading: Boolean = false,
    val isInvalidEmail: Boolean = false,
    val isUpdateSuccess: Boolean? = null,
)
