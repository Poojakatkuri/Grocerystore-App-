package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.UserRepository
import com.pooja.groceriesstore.di.IoDispatcher
import com.pooja.groceriesstore.domain.usecases.SignInUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

class SignInUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : SignInUseCase {
    override suspend fun invoke(input: SignInUseCase.Input): SignInUseCase.Output {
        return withContext(ioDispatcher) {
            try {
                val res = userRepository.authenticate(input.email, input.password)
                if (res) {
                    SignInUseCase.Output.Success
                } else {
                    SignInUseCase.Output.Error
                }
            } catch (e: Exception) {
                Timber.d(e.message)
                SignInUseCase.Output.AccountNotExistedError
            }
        }
    }
}