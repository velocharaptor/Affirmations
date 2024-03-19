package com.example.affirmations.uikit.discountprice

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
class DiscountPriceItem(
    val id: String,
    val price: String,
    val newPrice: String,
    val colorPrice: Int? = null,
    val colorNewPrice: Int? = null,
    val sizePrice: Float? = null,
    val sizeNewPrice: Float? = null,
) : RecyclerItem {
    override fun provideId() = id
}
