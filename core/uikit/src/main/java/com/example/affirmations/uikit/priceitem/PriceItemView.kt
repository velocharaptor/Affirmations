package com.example.affirmations.uikit.priceitem

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
class PriceItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private var priceItem: PriceItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.price_item, this)
        applyMargin(8)
        textView = findViewById(R.id.price_item_price)
    }

    @RecyclerItemStateBinder
    fun bindState(state: PriceItem) {
        priceItem = state
        textView.text = state.text
        state.color?.let { color ->
            textView.setTextColor(color)
        }
        state.size?.let { size ->
            textView.textSize = size
        }
    }
}