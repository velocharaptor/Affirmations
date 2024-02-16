package com.example.affirmations.data.home

import com.example.affirmations.domain.home.HomeModel
import com.example.affirmations.domain.home.HomePictureModel
import com.example.affirmations.domain.home.HomePriceModel
import com.example.affirmations.network.home.HomeResponse
import com.example.affirmations.network.home.PictureResponse
import com.example.affirmations.network.home.PriceResponse
import javax.inject.Inject

class HomeMapper @Inject constructor() {
    fun map(homeResponse: List<HomeResponse>): List<HomeModel> {
        return homeResponse.map { homeItem ->
            HomeModel(
                title = homeItem.title,
                price = mapPrice(homeItem.price),
                description = homeItem.description,
                pictures = mapPictures(homeItem.pictures)
            )
        }
    }

    private fun mapPrice(price: PriceResponse?): HomePriceModel {
        return HomePriceModel(
            price = price?.price ?: "",
            currency = price?.currency ?: ""
        )
    }

    private fun mapPictures(pictureResponse: List<PictureResponse>?): List<HomePictureModel> {
        return pictureResponse?.map { picture ->
            HomePictureModel(
                id = picture.id,
                title = picture.title,
                original = picture.original,
                web = picture.web,
                thumbnail = picture.thumbnail
            )
        } ?: emptyList()
    }
}