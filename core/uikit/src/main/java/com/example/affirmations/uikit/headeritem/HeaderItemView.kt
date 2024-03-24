package com.example.affirmations.uikit.headeritem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.utils.ext.setOptionalText

@RecyclerItemView
class HeaderItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr){
    private val titleView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.header_item, this)
        titleView = findViewById(R.id.header_title)
    }

    @RecyclerItemStateBinder
    fun bindState(state: HeaderItem) {
        titleView.text = state.title
    }
}