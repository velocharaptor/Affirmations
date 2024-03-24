package com.example.affirmations.uikit.divideritem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R

@RecyclerItemView
class DividerItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val view: View
    private var dividerItem: DividerItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.divider_item, this)
        view = findViewById(R.id.divider_item)
    }

    @RecyclerItemStateBinder
    fun bindState(state: DividerItem) {
        dividerItem = state
    }
}