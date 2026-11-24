package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.UserRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.SignOutUseCase
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