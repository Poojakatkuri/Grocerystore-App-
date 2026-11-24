package com.grocerystore.app.data.network

// Server table names used with the Supabase SDK (orders, users, line items).
// Example: postgrest[RemoteTable.Orders.tableName] means GET .../rest/v1/orders
// Products and categories are fetched with Retrofit instead: see SupabaseApi (FLOW step 2).
enum class RemoteTable(val tableName: String) {
    Product("products"),
    Categories("categories"),
    Orders("orders"),
    Users("users"),
    LineItems("line_items"),
}