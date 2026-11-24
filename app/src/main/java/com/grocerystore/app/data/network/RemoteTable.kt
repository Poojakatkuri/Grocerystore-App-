package com.grocerystore.app.data.network

enum class RemoteTable(val tableName: String) {
    Product("products"),
    Categories("categories"),
    Orders("orders"),
    Users("users"),
    LineItems("line_items"),
}