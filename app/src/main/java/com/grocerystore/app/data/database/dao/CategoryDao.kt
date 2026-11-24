package com.grocerystore.app.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grocerystore.app.data.database.entities.Category
import com.grocerystore.app.utilities.CATEGORY_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(category: List<Category>)

    @Query("SELECT * FROM $CATEGORY_TABLE")
    fun getAll(): Flow<List<Category>>
}
