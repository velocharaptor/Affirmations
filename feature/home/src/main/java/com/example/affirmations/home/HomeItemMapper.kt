package com.example.affirmations.feature.home

import com.example.affirmations.domain.home.HomeModel
import com.example.affirmations.uikit.homeitem.HomeItem


class HomeItemMapper {
    fun map(recommendation: List<HomeModel>): List<HomeItem> {
        return recommendation.map {
            HomeItem(
                title = it.title ?: "Product Name",
                images = "" /*it.pictures?.map { picture ->
                    picture.original
                } ?: emptyList()*/,
                id = it.title ?: "Product Name"
            )
        }
    }
}