package com.example.affirmations.domain.home


class HomeModel(
    val title: String?,
    val price: HomePriceModel?,
    val description: String?,
    val pictures: List<HomePictureModel>?
)

class HomePriceModel(
    val price: String,
    val currency: String
)

class HomePictureModel(
    val id: String,
    val title: String,
    val original: String,
    val web: String,
    val thumbnail: String
)
