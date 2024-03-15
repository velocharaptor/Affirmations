package com.example.affirmations.uikit.productitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.button.ButtonItemView
import com.example.affirmations.uikit.ext.load
import com.example.affirmations.utils.applyMargin

@RecyclerItemView
class ProductListItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private val imageView: ImageView
    private var productItem: ProductItem? = null
    private val backgroundView: View
    private val button: ButtonItemView

    init {
        LayoutInflater.from(context).inflate(R.layout.product_item, this)
        backgroundView = findViewById<ConstraintLayout>(R.id.product_item_background_layout)
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        textView = findViewById(R.id.product_title)
        imageView = findViewById(R.id.product_item_image)
        button = findViewById(R.id.product_item_button)
        setOnClickListener {
            productItem?.let { data ->
                data.toProductCard.invoke(data)
            }
        }
    }

    @RecyclerItemStateBinder
    fun bindState(productItem: ProductItem) {
        this.productItem = productItem
        textView.text = productItem.title
        imageView.load(productItem.images.getOrNull(0))

        button.bindState(productItem.button)

        productItem.backgroundColor?.let { color ->
            backgroundView.setBackgroundColor(color)
        }
    }
}