package com.example.affirmations.uikit.priceitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
class PriceItem(
    val id: String,
    val oldPrice: String? = null,
    val newPrice: String? = null,
    val colorPrice: Int? = null,
    val colorNewPrice: Int? = null,
    val sizePrice: Float? = null,
    val sizeNewPrice: Float? = null,
) : RecyclerItem {
    override fun provideId() = id
}
