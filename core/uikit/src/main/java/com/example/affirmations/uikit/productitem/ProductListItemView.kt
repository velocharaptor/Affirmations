package com.example.affirmations.uikit.productitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.button.ButtonItemView
import com.example.affirmations.uikit.priceitem.PriceItemView
import com.example.affirmations.utils.ext.load

@RecyclerItemView
class ProductListItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private val imageView: ImageView
    private var productItem: ProductItem? = null
    private val button: ButtonItemView
    private val priceItem: PriceItemView

    init {
        LayoutInflater.from(context).inflate(R.layout.product_item, this)

        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )

        textView = findViewById(R.id.product_title)
        imageView = findViewById(R.id.product_item_image)
        button = findViewById(R.id.product_item_button)
        priceItem = findViewById(R.id.product_item_price)

        setOnClickListener {
            productItem?.let { data ->
                data.toProductCard.invoke(data)
            }
        }
    }

    @RecyclerItemStateBinder
    fun bindState(state: ProductItem) {
        productItem = state

        textView.text = state.title
        imageView.load(state.images.getOrNull(0))

        button.bindState(state.button)
        state.priceView?.let { item ->
            priceItem.bindState(item)
        }
    }
}