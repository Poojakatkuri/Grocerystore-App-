package com.grocerystore.app.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.grocerystore.app.domain.models.UserModel
import com.grocerystore.app.utilities.USER_TABLE

@Entity(tableName = USER_TABLE)
class User(
    @PrimaryKey
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "address")
    var address: String?,

    @ColumnInfo(name = "phone")
    var phone: String?,

    @ColumnInfo(name = "isOrderCreatedNotiEnabled")
    var isOrderCreatedNotiEnabled: Boolean,

    @ColumnInfo(name = "isPromotionNotiEnabled")
    var isPromotionNotiEnabled: Boolean,

    @ColumnInfo(name = "isDataRefreshedNotiEnabled")
    var isDataRefreshedNotiEnabled: Boolean
)

fun User.asDomainModel(): UserModel {
    return UserModel(
        id = this.id,
        name = this.name,
        phone = this.phone ?: "",
        email = this.email,
        address = this.address ?: "",
        isDataRefreshedNotiEnabled = this.isDataRefreshedNotiEnabled,
        isOrderCreatedNotiEnabled = this.isOrderCreatedNotiEnabled,
        isPromotionNotiEnabled = this.isPromotionNotiEnabled
    )
}
