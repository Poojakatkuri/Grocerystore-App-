package com.grocerystore.app.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.grocerystore.app.domain.models.RecipeModel
import com.grocerystore.app.utilities.RECIPE_TABLE

@Entity(tableName = RECIPE_TABLE)
data class Recipe(
    @PrimaryKey
    var id: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "name")
    val name: String
)

fun List<Recipe>.asDomainModel(): List<RecipeModel> {
    return map {
        RecipeModel(
            id = it.id,
            name = it.name,
            image = it.image
        )
    }
}
