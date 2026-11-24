package com.pooja.groceriesstore.di

import android.content.Context
import androidx.room.Room
import com.pooja.groceriesstore.data.database.GroceriesStoreDatabase
import com.pooja.groceriesstore.data.database.dao.CategoryDao
import com.pooja.groceriesstore.data.database.dao.LineItemDao
import com.pooja.groceriesstore.data.database.dao.OrderDao
import com.pooja.groceriesstore.data.database.dao.ProductDao
import com.pooja.groceriesstore.data.database.dao.RecipeDao
import com.pooja.groceriesstore.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GroceriesStoreDatabase =
        Room.databaseBuilder(
            context,
            GroceriesStoreDatabase::class.java,
            "groceries_store.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideCategoryDao(database: GroceriesStoreDatabase): CategoryDao = database.categoryDao()

    @Provides
    fun provideProductDao(database: GroceriesStoreDatabase): ProductDao = database.productDao()

    @Provides
    fun provideLineItemDao(database: GroceriesStoreDatabase): LineItemDao = database.lineItemDao()

    @Provides
    fun provideOrderDao(database: GroceriesStoreDatabase): OrderDao = database.orderDao()

    @Provides
    fun provideUserDao(database: GroceriesStoreDatabase): UserDao = database.userDao()

    @Provides
    fun provideRecipeDao(database: GroceriesStoreDatabase): RecipeDao = database.recipeDao()
}
