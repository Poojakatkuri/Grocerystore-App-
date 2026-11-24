package com.grocerystore.app.domain.usecases

import com.grocerystore.app.domain.models.UserModel
import kotlinx.coroutines.flow.Flow

interface GetProfileUseCase:SuspendUseCase<GetProfileUseCase.Input, GetProfileUseCase.Output> {
    class Input
    open class Output(val result: Flow<UserModel?>)
}
