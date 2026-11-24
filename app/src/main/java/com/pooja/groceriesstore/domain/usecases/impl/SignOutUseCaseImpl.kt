package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.UserRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.SignOutUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SignOutUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SignOutUseCase {
    override suspend fun invoke(input: SignOutUseCase.Input): SignOutUseCase.Output {
        return withContext(ioDispatcher) {
            userRepository.clearUser()
            SignOutUseCase.Output()
        }
    }
}