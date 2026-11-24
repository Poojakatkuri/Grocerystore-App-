package com.grocerystore.app.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// FLOW step 3 (network model): DTO = "Data Transfer Object" = the product exactly as the SERVER sends it.
// @SerialName maps each JSON field name to a Kotlin property. Used only inside the data layer.
@Serializable
data class ProductDto(
    @SerialName("id")
    val productId: String,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: Double,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String,
    @SerialName("nutrition")
    val nutrition: String,
)
