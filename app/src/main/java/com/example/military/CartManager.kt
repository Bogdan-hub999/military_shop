package com.example.military

object CartManager {
    // Список товарів у кошику
    val cartItems = mutableListOf<CartItem>()

    // Додавання поштучно
    fun addToCart(product: Product) {
        val existingItem = cartItems.find { it.product.id == product.id }
        if (existingItem != null) {
            existingItem.quantity += 1 // Якщо вже є, збільшуємо кількість
        } else {
            cartItems.add(CartItem(product, 1)) // Якщо немає, додаємо новий
        }
    }

    // Рахуємо загальну кількість товарів (для іконки)
    fun getTotalItemsCount(): Int {
        return cartItems.sumOf { it.quantity }
    }

    // Рахуємо загальну суму (для оформлення замовлення)
    fun getTotalPrice(): Int {
        return cartItems.sumOf { it.product.price * it.quantity }
    }
}