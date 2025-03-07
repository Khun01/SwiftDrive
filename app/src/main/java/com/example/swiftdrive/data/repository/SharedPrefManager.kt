package com.example.swiftdrive.data.repository

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object{
        private const val KEY_USER_ID = "user_id"
        private const val KEY_TOKEN = "auth_token"
    }

    fun saveUserData(userId: String, token: String) {
        editor.putString(KEY_USER_ID, userId)
        editor.putString(KEY_TOKEN, token)
        editor.apply()  // Apply changes
    }

    fun getUserId(): String? {
        return sharedPreferences.getString(KEY_USER_ID, null)
    }

    // Get stored token
    fun getToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

    // Clear stored data (logout)
    fun clearData() {
        editor.clear()
        editor.apply()
    }
}