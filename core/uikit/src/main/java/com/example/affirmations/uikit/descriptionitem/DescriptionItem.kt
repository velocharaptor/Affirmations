package com.example.affirmations.uikit.descriptionitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class DescriptionItem (
    val id: String,
    val text: String,
    val size: Float? = null,
    val textStyle: String? = null
) : RecyclerItem {
    override fun provideId() = id
}