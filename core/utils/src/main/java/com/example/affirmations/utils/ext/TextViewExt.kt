package com.example.affirmations.utils.ext

import android.widget.TextView
import androidx.core.view.isVisible

fun TextView.setOptionalText(string: String?) {
    isVisible = !string.isNullOrEmpty()
    text = string
}