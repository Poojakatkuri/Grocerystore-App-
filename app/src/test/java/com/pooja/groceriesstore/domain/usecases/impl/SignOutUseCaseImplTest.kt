package com.pooja.groceriesstore.domain.usecases.impl

import com.pooja.groceriesstore.data.repository.UserRepository
import com.pooja.groceriesstore.domain.usecases.SignOutUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class SignOutUseCaseImplTest {

    @Mock
    lateinit var mockedUserRepository: UserRepository
    private lateinit var testee: SignOutUseCase

    @Before
    fun setup() {
        testee = SignOutUseCaseImpl(
            userRepository = mockedUserRepository,
            ioDispatcher = Dispatchers.IO
        )
    }

    @Test
    fun whenExecute_thenCallUserRepository() {
        val input = SignOutUseCase.Input()

        runBlocking {
            testee(input)

            verify(mockedUserRepository).clearUser()
        }
    }
}