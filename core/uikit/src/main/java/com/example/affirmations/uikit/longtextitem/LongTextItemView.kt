package com.example.affirmations.uikit.longtextitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.utils.StateUtils
import com.example.affirmations.utils.ext.applyMargin

@RecyclerItemView
class LongTextItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private var longTextItem: LongTextItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.long_text_item, this)
        applyMargin(8)
        textView = findViewById(R.id.long_text_item_text)
    }

    @RecyclerItemStateBinder
    fun bindState(state: LongTextItem) {
        longTextItem = state
        textView.text = state.text
        StateUtils.setTextSize(textView, state.size)
    }
}