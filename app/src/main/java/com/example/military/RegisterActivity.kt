package com.example.military

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.military.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var authManager: AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authManager = AuthManager(this)

        binding.btnFinalRegister.setOnClickListener {
            val user = binding.etRegUsername.text.toString().trim()
            val pass = binding.etRegPassword.text.toString().trim()
            val confirm = binding.etConfirmPassword.text.toString().trim()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Заповни всі поля!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass != confirm) {
                Toast.makeText(this, "Паролі не збігаються!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ЗБЕРІГАЄМО
            authManager.registerUser(user, pass)
            Toast.makeText(this, "Акаунт створено! Увійдіть", Toast.LENGTH_LONG).show()

            // Закриваємо це вікно і повертаємось на логін
            finish()
        }
    }
}