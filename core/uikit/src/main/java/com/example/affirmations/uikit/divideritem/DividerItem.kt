package com.example.affirmations.uikit.divideritem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class DividerItem(
    val id: String,
    val color: Int?
) : RecyclerItem {
        override fun provideId() = id
}