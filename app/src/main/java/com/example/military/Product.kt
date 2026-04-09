package com.example.military

// Сам товар
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int
)

// Товар у кошику (зберігає кількість)
data class CartItem(
    val product: Product,
    var quantity: Int
)