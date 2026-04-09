package com.example.military

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.military.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ShopViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ініціалізація ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        // Клієнт натискає на кошик -> відкриваємо екран кошика
        binding.fabCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        // Налаштовуємо список товарів та клік по кнопці "Купити"
        val adapter = ProductAdapter(viewModel.products) { selectedProduct ->
            viewModel.addToCart(selectedProduct)
            Toast.makeText(this, "Додано: ${selectedProduct.name}", Toast.LENGTH_SHORT).show()
        }

        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = adapter
    }
}