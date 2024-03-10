package com.example.affirmations.uikit.productcarditem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.ext.load
import com.example.affirmations.utils.applyMargin
import com.example.affirmations.utils.setBackground
import com.google.android.material.card.MaterialCardView

@RecyclerItemView
class ProductCardItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val imageView: ImageView
    private var productCardItem: ProductCardItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.image_item, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        applyMargin(8)
        productCardItem?.backgroundColor?.let { color ->
            setBackgroundColor(color)
        }
        imageView = findViewById(R.id.image_item_image)
    }

    @RecyclerItemStateBinder
    fun bindState(productCardItem: ProductCardItem) {
        this.productCardItem = productCardItem
        imageView.load(productCardItem.image)
    }
}