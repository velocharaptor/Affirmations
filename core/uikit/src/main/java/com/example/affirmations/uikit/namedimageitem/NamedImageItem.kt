package com.example.affirmations.uikit.namedimageitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class NamedImageItem(
    val id: String,
    val title: String,
    val image: String
) : RecyclerItem {
    override fun provideId() = id
}
