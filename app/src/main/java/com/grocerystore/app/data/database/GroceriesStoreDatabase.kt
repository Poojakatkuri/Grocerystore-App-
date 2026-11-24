package com.grocerystore.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grocerystore.app.data.database.dao.CategoryDao
import com.grocerystore.app.data.database.dao.LineItemDao
import com.grocerystore.app.data.database.dao.OrderDao
import com.grocerystore.app.data.database.dao.ProductDao
import com.grocerystore.app.data.database.dao.RecipeDao
import com.grocerystore.app.data.database.dao.UserDao
import com.grocerystore.app.data.database.entities.Category
import com.grocerystore.app.data.database.entities.LineItem
import com.grocerystore.app.data.database.entities.Order
import com.grocerystore.app.data.database.entities.Product
import com.grocerystore.app.data.database.entities.Recipe
import com.grocerystore.app.data.database.entities.User

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
