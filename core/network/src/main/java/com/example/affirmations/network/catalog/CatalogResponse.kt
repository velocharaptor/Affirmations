package com.example.affirmations.network.catalog

import com.google.gson.annotations.SerializedName

data class CatalogResponse(
    val name: String?,
    val items: List<Item>?
)

data class Item(
    @SerializedName("title") val title: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("icon") val icon: String?,
    @SerializedName("mobile_icon") val mobileIcon: String?,
    @SerializedName("backgroundImage") val backgroundImage: String?,
    @SerializedName("categoryAlias") val categoryAlias: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("items") val items: List<Item>?
)
