package com.example.affirmations.utils.resmanager

import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.core.content.ContextCompat

class ResManagerImpl(
    private val context: Context
): ResManager {
    override fun getDrawable(id: Int): Drawable? {
        return ContextCompat.getDrawable(context, id)
    }

    override fun getString(id: Int): String {
        return context.getString(id)
    }

    override fun getColor(id: Int): Int  {
        return ContextCompat.getColor(context, id)
    }

    override fun showToast(id: Int, duration: Int) {
        Toast.makeText(context, getString(id), duration).show()
    }

    override fun showToast(text: String, duration: Int) {
        Toast.makeText(context, text, duration).show()
    }

    @Suppress("DEPRECATION")
    override fun getDefaultSharedPreferences(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}