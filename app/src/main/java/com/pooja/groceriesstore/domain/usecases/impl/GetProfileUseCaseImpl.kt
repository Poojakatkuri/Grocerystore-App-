package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.UserRepository
import com.pooja.groceriesstore.domain.usecases.GetProfileUseCase
import javax.inject.Inject

class GetProfileUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
) : GetProfileUseCase {
    override suspend fun invoke(input: GetProfileUseCase.Input): GetProfileUseCase.Output {
        val user = userRepository.getCurrentUser()
        return GetProfileUseCase.Output(user)
    }
}