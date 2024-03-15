package com.example.affirmations.uikit.button

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class ButtonItem(
    val id: String,
    val title: String,
    val size: ButtonSize = ButtonSize.BIG,
    val action: (data: RecyclerItem) -> Unit
) : RecyclerItem {
    override fun provideId() = id
}

enum class ButtonSize{
    BIG, SMALL
}