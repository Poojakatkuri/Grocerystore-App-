package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.UserRepository
import com.pooja.groceriesstore.domain.usecases.UpdateProfileUseCase
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