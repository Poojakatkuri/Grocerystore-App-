package com.pooja.groceriesstore.presentation.updateprofile

import com.pooja.groceriesstore.domain.models.UserModel

data class UpdateProfileUiState(
    val user: UserModel? = null,
    val isLoading: Boolean = false,
    val isInvalidEmail: Boolean = false,
    val isUpdateSuccess: Boolean? = null,
)
