package com.example.affirmations.utils.resmanager

import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface ResManager {
    fun getDrawable(@DrawableRes id: Int): Drawable?

    fun getString(@StringRes id: Int): String

    fun getColor(@ColorRes id: Int): Int

    fun showToast(id: Int, duration: Int)

    fun showToast(text: String, duration: Int)

    fun getDefaultSharedPreferences(): SharedPreferences
}