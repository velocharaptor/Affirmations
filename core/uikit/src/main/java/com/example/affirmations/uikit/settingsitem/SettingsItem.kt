package com.example.affirmations.uikit.settingsitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class SettingsItem(
    val id: String,
    val title: String,
    val description: String,
    val key: String,
    val isEnabled: Boolean,
    val action: (key: String, isEnabled: Boolean) -> Unit
) : RecyclerItem {
    override fun provideId() = id
}