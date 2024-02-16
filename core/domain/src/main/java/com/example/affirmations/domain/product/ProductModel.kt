package com.example.affirmations.domain.product

class ProductModel(
    val title: String?,
    val price: PriceModel?,
    val description: String?,
    val pictures: List<PictureModel>?
)

class PriceModel(
    val price: String,
    val currency: String
)

class PictureModel(
    val id: String,
    val title: String,
    val original: String,
    val web: String,
    val thumbnail: String
)
