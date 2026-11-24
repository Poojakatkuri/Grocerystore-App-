package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.UserRepository
import com.grocerystore.app.domain.usecases.GetProfileUseCase
import javax.inject.Inject

class GetProfileUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
) : GetProfileUseCase {
    override suspend fun invoke(input: GetProfileUseCase.Input): GetProfileUseCase.Output {
        val user = userRepository.getCurrentUser()
        return GetProfileUseCase.Output(user)
    }
}