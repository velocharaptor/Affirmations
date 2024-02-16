package com.example.affirmations.uikit.homeitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class HomeItem(
    val id: String,
    val title: String,
    val images: String
) : RecyclerItem {
    override fun provideId() = id
}
