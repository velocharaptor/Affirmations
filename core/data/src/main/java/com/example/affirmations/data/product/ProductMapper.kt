package com.example.affirmations.data.product

import com.example.affirmations.domain.product.PictureModel
import com.example.affirmations.domain.product.PriceModel
import com.example.affirmations.domain.product.ProductModel
import com.example.affirmations.network.PictureResponse
import com.example.affirmations.network.PriceResponse
import com.example.affirmations.network.ProductResponse
import javax.inject.Inject

class ProductMapper @Inject constructor() {
    fun map(productResponse: List<ProductResponse>): List<ProductModel> {
        return productResponse.map { product ->
            ProductModel(
                title = product.title,
                price = mapPrice(product.price),
                description = product.description,
                pictures = mapPictures(product.pictures)
            )
        }
    }

    private fun mapPrice(price: PriceResponse?): PriceModel {
        return PriceModel(
            price = price?.price.orEmpty(),
            currency = price?.currency.orEmpty()
        )
    }

    private fun mapPictures(pictureResponse: List<PictureResponse>?): List<PictureModel> {
        return pictureResponse?.map { picture ->
            PictureModel(
                id = picture.id,
                title = picture.title,
                original = picture.original,
                web = picture.web,
                thumbnail = picture.thumbnail
            )
        } ?: emptyList()
    }
}