package com.example.affirmations.preferences

import android.content.SharedPreferences
import javax.inject.Inject

@Suppress("DEPRECATION")
class Preferences @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun putString(key: String, value: String) {
        sharedPreferences.edit()
            .putString(key, value)
            .commit()
    }

    fun removeString(key: String) {
        sharedPreferences.edit()
            .remove(key)
            .commit()
    }

    fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun putInt(key: String, value: Int) {
        sharedPreferences.edit()
            .putInt(key, value)
            .commit()
    }

    fun removeInt(key: String) {
        sharedPreferences.edit()
            .remove(key)
            .commit()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit()
            .putBoolean(key, value)
            .commit()
    }

    fun removeBoolean(key: String) {
        sharedPreferences.edit()
            .remove(key)
            .commit()
    }
}