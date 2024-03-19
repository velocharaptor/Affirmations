package com.example.affirmations.uikit.discountprice

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.strikethroughtextview.StrikethroughTextItemView
import com.example.affirmations.utils.applyMargin

@RecyclerItemView
class DiscountPriceItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private val strikeTextView: StrikethroughTextItemView
    private var discountPriceItem: DiscountPriceItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.discount_item, this)
        applyMargin(8)
        textView = findViewById(R.id.discount_item_price)
        strikeTextView = findViewById(R.id.discount_item_new_price)
    }

    @RecyclerItemStateBinder
    fun bindState(state: DiscountPriceItem) {
        discountPriceItem = state
        textView.text = state.newPrice
        strikeTextView.text = state.price
        state.colorNewPrice?.let { color ->
            textView.setTextColor(color)
        }
        state.sizeNewPrice?.let { size ->
            textView.textSize = size
        }
        state.colorPrice?.let { color ->
            strikeTextView.setTextColor(color)
        }
        state.sizePrice?.let { size ->
            strikeTextView.textSize = size
        }
    }
}