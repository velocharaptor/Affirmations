package com.example.affirmations.uikit.productitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.ext.load
import com.example.affirmations.utils.applyMargin
import com.google.android.material.card.MaterialCardView

@RecyclerItemView
class ProductListItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private val textView: TextView
    private val imageView: ImageView
    private var productItem: ProductItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        applyMargin(8)
        textView = findViewById(R.id.item_title)
        imageView = findViewById(R.id.item_image)
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
    }
}