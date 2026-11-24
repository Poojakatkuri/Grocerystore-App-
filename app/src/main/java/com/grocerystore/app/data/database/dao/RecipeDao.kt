package com.grocerystore.app.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grocerystore.app.data.database.entities.Recipe
import com.grocerystore.app.utilities.RECIPE_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(recipes: List<Recipe>)

    @Query("SELECT * FROM $RECIPE_TABLE")
    fun getAll(): Flow<List<Recipe>>
}
