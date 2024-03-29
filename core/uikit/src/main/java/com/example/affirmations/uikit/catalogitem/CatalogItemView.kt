package com.example.affirmations.uikit.catalogitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.utils.ext.load

@RecyclerItemView
class CatalogItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private val imageView: ImageView
    private var catalogItem: CatalogItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.catalog_item, this)
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        textView = findViewById(R.id.catalog_text)
        imageView = findViewById(R.id.catalog_image)
        setOnClickListener {
            catalogItem?.let { data ->
                data.action.invoke(data.categoryAlias)
            }
        }
    }

    @RecyclerItemStateBinder
    fun bindState(state: CatalogItem) {
        catalogItem = state
        textView.text = state.name
        imageView.load(state.image)
    }
}