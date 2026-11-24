package com.grocerystore.app.data.database.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.grocerystore.app.domain.models.ProductModel
import com.grocerystore.app.utilities.PRODUCT_TABLE

// FLOW step 7 (local database model): one row of the "product" table in Room (the phone database).
@Entity(tableName = PRODUCT_TABLE)
data class Product(
    @PrimaryKey
    @ColumnInfo(name = "productId")
    val id: String,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "price")
    var price: Double?,

    @ColumnInfo(name = "image")
    var image: String?,

    @ColumnInfo(name = "category")
    var category: String?,

    @ColumnInfo(name = "nutrition")
    var nutrition: String?
)

fun List<Product>.asDomainModel(): List<ProductModel> {
    return map {
        it.asDomainModel()
    }
}

// Converter: database entity -> clean domain model used by use cases, ViewModels and screens.
fun Product.asDomainModel(): ProductModel {
    return ProductModel(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        image = this.image,
        nutrition = this.nutrition
    )
}
