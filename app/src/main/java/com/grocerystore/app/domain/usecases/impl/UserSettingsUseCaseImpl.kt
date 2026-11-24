package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.UserRepository
import com.grocerystore.app.di.IoDispatcher
import com.grocerystore.app.domain.usecases.UserSettingsUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UserSettingsUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UserSettingsUseCase {

    override suspend fun invoke(input: UserSettingsUseCase.Input): UserSettingsUseCase.Output {
        withContext(ioDispatcher) {
            userRepository.updateUserSettings(
                input.id,
                input.isOrderCreatedEnabled,
                input.isDatabaseRefreshedEnabled,
                input.isPromotionEnabled
            )
        }
        return UserSettingsUseCase.Output()
    }
}