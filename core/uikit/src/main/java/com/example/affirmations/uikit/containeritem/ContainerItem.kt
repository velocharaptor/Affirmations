package com.example.affirmations.uikit.containeritem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class ContainerItem (
    val id: String,
    val recyclerState: List<RecyclerItem>
): RecyclerItem{
    override fun provideId(): String {
        return id
    }
}