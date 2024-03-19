package com.example.affirmations.uikit.priceitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class PriceItem(
    val id: String,
    val text: String,
    val color: Int? = null,
    val size: Float? = null,
    val textStyle: String? = null
    ) : RecyclerItem {
    override fun provideId() = id
}