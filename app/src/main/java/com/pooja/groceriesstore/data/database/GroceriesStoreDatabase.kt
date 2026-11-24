package com.pooja.groceriesstore.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pooja.groceriesstore.data.database.dao.CategoryDao
import com.pooja.groceriesstore.data.database.dao.LineItemDao
import com.pooja.groceriesstore.data.database.dao.OrderDao
import com.pooja.groceriesstore.data.database.dao.ProductDao
import com.pooja.groceriesstore.data.database.dao.RecipeDao
import com.pooja.groceriesstore.data.database.dao.UserDao
import com.pooja.groceriesstore.data.database.entities.Category
import com.pooja.groceriesstore.data.database.entities.LineItem
import com.pooja.groceriesstore.data.database.entities.Order
import com.pooja.groceriesstore.data.database.entities.Product
import com.pooja.groceriesstore.data.database.entities.Recipe
import com.pooja.groceriesstore.data.database.entities.User

@Database(
    entities = [Product::class, LineItem::class, Order::class, Category::class, User::class, Recipe::class],
    version = 1,
    exportSchema = false
)
abstract class GroceriesStoreDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun lineItemDao(): LineItemDao
    abstract fun orderDao(): OrderDao
    abstract fun categoryDao(): CategoryDao
    abstract fun userDao(): UserDao
    abstract fun recipeDao(): RecipeDao
}
