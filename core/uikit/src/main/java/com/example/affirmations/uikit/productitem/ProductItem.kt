package com.example.affirmations.uikit.productitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState
import com.example.affirmations.uikit.button.ButtonItem
import com.example.affirmations.uikit.priceitem.PriceItem

@RecyclerItemState
data class ProductItem(
    val id: String,
    val title: String,
    val images: List<String>,
    val description: String,
    val price: String,
    val button: ButtonItem,
    val priceView: PriceItem? = null,
    val toProductCard: (data: ProductItem) -> Unit,
) : RecyclerItem {
    override fun provideId() = id
}

