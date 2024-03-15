package com.example.affirmations.navigation.transportmodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ProductItemTransport(
    val id: String,
    val title: String,
    val images: List<String>,
    val description: String,
    val price: String
) : Parcelable