package com.example.military

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.military.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var authManager: AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authManager = AuthManager(this)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ТЕПЕР ЦЯ КНОПКА ПРОСТО ВІДКРИВАЄ ВІКНО РЕЄСТРАЦІЇ
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // КНОПКА ВХОДУ (Залишається без змін)
        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()

            if (authManager.loginUser(user, pass)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Невірні дані або акаунт не створено!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}