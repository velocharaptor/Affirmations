package com.example.affirmations.uikit.longtextitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class LongTextItem(
    val id: String,
    val text: String,
    val size: Float? = null,
    val textStyle: String? = null
) : RecyclerItem {
    override fun provideId() = id
}