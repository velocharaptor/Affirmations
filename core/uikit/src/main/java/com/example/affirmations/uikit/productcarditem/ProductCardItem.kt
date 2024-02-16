package com.example.affirmations.uikit.productcarditem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class ProductCardItem(
    val id: String,
    val image: String
) : RecyclerItem{
    override fun provideId() = id
}