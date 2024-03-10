package com.example.affirmations.uikit.productitem

import android.os.Parcelable
import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState
import kotlinx.parcelize.Parcelize

@RecyclerItemState
@Parcelize
data class ProductItem(
    val id: String,
    val title: String,
    val images: List<String>,
    val description: String,
    val price: String,
    val button: Class<RecyclerItem>? = null,
    val backgroundColor: Int? = null,
    val toProductCard : (data: ProductItem) -> Unit,
) : Parcelable, RecyclerItem {
    override fun provideId() = id
}

