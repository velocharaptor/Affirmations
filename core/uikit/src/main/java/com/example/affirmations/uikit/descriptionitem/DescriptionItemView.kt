package com.example.affirmations.uikit.descriptionitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.utils.applyMargin

@RecyclerItemView
class DescriptionItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private var descriptionItem: DescriptionItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.description_item, this)
        applyMargin(8)
        textView = findViewById(R.id.description_item_description)
    }

    @RecyclerItemStateBinder
    fun bindState(state: DescriptionItem){
        descriptionItem = state
        textView.text = state.text
        state.size?.let { size ->
            textView.textSize = size
        }
    }
}