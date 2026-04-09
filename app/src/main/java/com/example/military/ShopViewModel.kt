package com.example.military

import androidx.lifecycle.ViewModel

class ShopViewModel : ViewModel() {

    // Більший вибір товарів!
    val products = listOf(
        Product(1, "Шолом FAST", "Балістичний шолом рівня NIJ IIIA", 8500),
        Product(2, "Плитоноска", "Тактичний жилет з системою MOLLE", 4200),
        Product(3, "Бронеплити", "Комплект керамічних плит 6 класу", 12000),
        Product(4, "Аптечка IFAK", "Індивідуальна тактична аптечка з турнікетом", 2500),
        Product(5, "Тактичні рукавиці", "Із захистом кісточок, сенсорні", 800),
        Product(6, "Берці Lowa", "Зимові тактичні черевики, Gore-Tex", 7500),
        Product(7, "РПС", "Ремінно-плечова система для підсумків", 1500)
    )

    fun addToCart(product: Product) {
        CartManager.addToCart(product)
    }
}