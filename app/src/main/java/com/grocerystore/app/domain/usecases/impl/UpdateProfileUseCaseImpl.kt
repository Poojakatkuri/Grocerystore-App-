package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.UserRepository
import com.grocerystore.app.domain.usecases.UpdateProfileUseCase
import javax.inject.Inject

class UpdateProfileUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
) : UpdateProfileUseCase {
    override suspend fun invoke(input: UpdateProfileUseCase.Input): UpdateProfileUseCase.Output {
        userRepository.updateUserProfile(
            input.userId, input.name, input.email, input.phone, input.address
        )
        return UpdateProfileUseCase.Output()
    }
}