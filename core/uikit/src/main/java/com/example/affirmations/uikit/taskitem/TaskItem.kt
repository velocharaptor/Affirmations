package com.example.affirmations.uikit.taskitem

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class TaskItem (
    val id: String,
    val title: String,
    val text: String
): RecyclerItem {
    override fun provideId() = id
}

