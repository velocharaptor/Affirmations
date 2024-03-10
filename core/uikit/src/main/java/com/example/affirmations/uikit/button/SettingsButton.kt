package com.example.affirmations.uikit.button

import android.view.ViewGroup.LayoutParams
import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class SettingsButton(
    val id: String,
    val title: String,
    val lps: Pair<Int, Int>? = null,
    val action: (data: RecyclerItem) -> Unit
) : RecyclerItem {
    override fun provideId() = id
}