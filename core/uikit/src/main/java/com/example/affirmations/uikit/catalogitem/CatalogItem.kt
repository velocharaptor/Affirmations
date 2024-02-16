package com.example.affirmations.uikit.catalogitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class CatalogItem(
    val id: String,
    val name: String,
    val image: String,
    val categoryAlias: String,
    val action: (categoryAlias: String) -> Unit
) : RecyclerItem {
    override fun provideId() = id
}