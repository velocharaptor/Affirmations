package com.example.affirmations.network.home

data class HomeResponse(
    val title: String?,
    val price: PriceResponse?,
    val description: String?,
    val pictures: List<PictureResponse>?
)

data class PriceResponse(
        val price: String,
        val currency: String
)

data class PictureResponse(
        val id: String,
        val title: String,
        val original: String,
        val web: String,
        val thumbnail: String
)