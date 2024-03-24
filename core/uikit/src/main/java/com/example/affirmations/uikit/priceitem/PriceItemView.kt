package com.example.affirmations.uikit.priceitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.strikethroughtextview.StrikethroughTextItemView
import com.example.affirmations.utils.StateUtils
import com.example.affirmations.utils.ext.applyMargin
import com.example.affirmations.utils.ext.setOptionalText

@RecyclerItemView
class PriceItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private val strikeTextView: StrikethroughTextItemView
    private var priceItem: PriceItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.price_item, this)
        applyMargin(8)
        textView = findViewById(R.id.price_item_new_price)
        strikeTextView = findViewById(R.id.price_item_old_price)
    }

    @RecyclerItemStateBinder
    fun bindState(state: PriceItem) {
        priceItem = state

        strikeTextView.isStrike = !state.newPrice.isNullOrEmpty()
        strikeTextView.setOptionalText(state.oldPrice)
        textView.setOptionalText(state.newPrice)

        StateUtils.setTextColor(textView, state.colorNewPrice)
        StateUtils.setTextSize(textView, state.sizeNewPrice)
        StateUtils.setTextColor(strikeTextView, state.colorPrice)
        StateUtils.setTextSize(strikeTextView, state.sizePrice)
    }
}