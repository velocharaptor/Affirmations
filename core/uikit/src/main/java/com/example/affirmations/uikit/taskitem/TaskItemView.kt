package com.example.affirmations.uikit.taskitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.headeritem.HeaderItem

@RecyclerItemView
class TaskItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr){
    private val titleView: TextView
    private val textView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.task_item, this)
        titleView = findViewById(R.id.task_title)
        textView = findViewById(R.id.task_text)
    }

    @RecyclerItemStateBinder
    fun bindState(taskItem: TaskItem) {
        titleView.text = taskItem.title
        textView.text = taskItem.text
    }
}