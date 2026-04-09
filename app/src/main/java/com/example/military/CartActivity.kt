package com.example.military

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.military.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Підключаємо дизайн
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Налаштовуємо список товарів у кошику
        binding.rvCartItems.layoutManager = LinearLayoutManager(this)
        binding.rvCartItems.adapter = CartAdapter(CartManager.cartItems)

        // Виводимо загальну суму
        binding.tvTotalCartPrice.text = "До сплати: ${CartManager.getTotalPrice()} грн"

        // Логіка кнопки "Замовити"
        binding.btnSubmitOrder.setOnClickListener {
            val name = binding.etCustomerName.text.toString()
            val phone = binding.etCustomerPhone.text.toString()

            // Перевіряємо, чи ввів клієнт дані
            if (name.isBlank() || phone.isBlank()) {
                Toast.makeText(this, "Будь ласка, введіть ім'я та телефон", Toast.LENGTH_SHORT).show()
            } else if (CartManager.cartItems.isEmpty()) {
                Toast.makeText(this, "Ваш кошик порожній", Toast.LENGTH_SHORT).show()
            } else {
                // Замовлення успішне!
                Toast.makeText(this, "Дякуємо, $name! Замовлення прийнято.", Toast.LENGTH_LONG).show()
                CartManager.cartItems.clear() // Очищаємо кошик
                finish() // Закриваємо Кошик і повертаємось на Головний екран
            }
        }
    }
}