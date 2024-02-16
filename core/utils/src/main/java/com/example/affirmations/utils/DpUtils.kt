package com.example.affirmations.utils

import android.content.res.Resources

object DpUtils {
    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }
}