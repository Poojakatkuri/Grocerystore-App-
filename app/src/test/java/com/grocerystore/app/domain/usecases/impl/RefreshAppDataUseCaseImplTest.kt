package com.grocerystore.app.domain.usecases.impl

import com.grocerystore.app.data.repository.CategoryRepository
import com.grocerystore.app.data.repository.ProductRepository
import com.grocerystore.app.data.repository.RecipeRepository
import com.grocerystore.app.domain.usecases.RefreshAppDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class RefreshAppDataUseCaseImplTest {

    @Mock
    lateinit var mockedProductRepository: ProductRepository

    @Mock
    lateinit var mockedCategoryRepository: CategoryRepository

    @Mock
    lateinit var mockedRecipeRepository: RecipeRepository

    private lateinit var testee: RefreshAppDataUseCase

    @Before
    fun setup() {
        testee = RefreshAppDataUseCaseImpl(
            productRepository = mockedProductRepository,
            categoryRepository = mockedCategoryRepository,
            recipeRepository = mockedRecipeRepository,
            ioDispatcher = Dispatchers.IO
        )
    }

    @Test
    fun whenExecute_thenCallRepositories() {
        runBlocking {
            testee(Unit)

            verify(mockedProductRepository).refreshDatabase()
            verify(mockedCategoryRepository).refreshDatabase()
            verify(mockedRecipeRepository).refreshDatabase()
        }
    }
}