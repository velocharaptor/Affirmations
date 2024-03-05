package com.example.affirmations.uikit.headeritem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R

@RecyclerItemView
class HeaderItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr){
    private val title: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.header_item, this)
        title = findViewById(R.id.header_title)
    }

    @RecyclerItemStateBinder
    fun bindState(headerItem: HeaderItem) {
        title.text = headerItem.title
    }
}