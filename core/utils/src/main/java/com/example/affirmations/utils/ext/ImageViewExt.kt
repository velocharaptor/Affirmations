package com.example.affirmations.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

inline fun ImageView.load(imageUrl: String?) {
    Glide.with(this)
        .load(imageUrl)
        .into(this)
}