package com.example.affirmations.uikit.button

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class SettingsButton(
    val id: String,
    val title: String,
    val action: (data: RecyclerItem) -> Unit
) : RecyclerItem {
    override fun provideId() = id
}