package com.example.affirmations.utils

import android.view.View
import android.view.ViewGroup

fun View.applyMargin(margin: Int) {
    this.setMargins(margin, margin, margin, margin)
}

fun View.setMargins(left: Int, top: Int, right: Int, bottom: Int) {
    val lp = this.layoutParams
    if (lp !is ViewGroup.MarginLayoutParams) return

    lp.leftMargin = DpUtils.dpToPx(left)
    lp.topMargin = DpUtils.dpToPx(top)
    lp.rightMargin = DpUtils.dpToPx(right)
    lp.bottomMargin = DpUtils.dpToPx(bottom)
}

fun View.setBackground(color: Int) {
   this.setBackgroundColor(color)
}