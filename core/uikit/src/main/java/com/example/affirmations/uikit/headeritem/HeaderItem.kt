package com.example.affirmations.uikit.headeritem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class HeaderItem (
    val id: String,
    val title: String
) : RecyclerItem {
    override fun provideId() = id
}