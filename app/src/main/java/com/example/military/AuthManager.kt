package com.example.military

import android.content.Context
import android.content.SharedPreferences

class AuthManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("MilitaryAppPrefs", Context.MODE_PRIVATE)

    fun registerUser(username: String, pass: String) {
        prefs.edit().putString("SAVED_USERNAME", username).putString("SAVED_PASSWORD", pass).apply()
    }

    fun loginUser(username: String, pass: String): Boolean {
        val savedUser = prefs.getString("SAVED_USERNAME", null)
        val savedPass = prefs.getString("SAVED_PASSWORD", null)
        if (username == savedUser && pass == savedPass) {
            prefs.edit().putBoolean("IS_LOGGED_IN", true).apply()
            return true
        }
        return false
    }

    fun isUserLoggedIn(): Boolean = prefs.getBoolean("IS_LOGGED_IN", false)
    fun logout() = prefs.edit().putBoolean("IS_LOGGED_IN", false).apply()
}