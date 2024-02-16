package com.example.affirmations.uikit.productcarditem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.ext.load
import com.example.affirmations.utils.applyMargin
import com.google.android.material.card.MaterialCardView

@RecyclerItemView
class ProductCardItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private val imageView: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        applyMargin(8)
        imageView = findViewById(R.id.item_image)
    }

    @RecyclerItemStateBinder
    fun bindState(productCardItem: ProductCardItem) {
        imageView.load(productCardItem.image)
    }
}