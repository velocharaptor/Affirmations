package com.example.affirmations.utils

import android.widget.FrameLayout
import android.widget.TextView

object StateUtils {
    fun setTextColor(view: TextView, color: Int?) {
        color?.let { it ->
            view.setTextColor(it)
        }
    }

    fun setTextSize(view: TextView, size: Float?) {
        size?.let { it ->
            view.textSize = it
        }
    }

}