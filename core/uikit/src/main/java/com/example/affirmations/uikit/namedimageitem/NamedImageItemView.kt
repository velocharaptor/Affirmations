package com.example.affirmations.uikit.namedimageitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.utils.ext.load
import com.example.affirmations.utils.ext.applyMargin
import com.example.affirmations.utils.ext.setOptionalText

@RecyclerItemView
class NamedImageItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    private val imageView: ImageView
    private var namedImageItem: NamedImageItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.named_image_item, this)
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        applyMargin(8)
        textView = findViewById(R.id.named_image_item_title)
        imageView = findViewById(R.id.named_image_item_image)

    }

    @RecyclerItemStateBinder
    fun bindState(state: NamedImageItem){
        namedImageItem = state
        textView.setOptionalText(state.title)
        imageView.load(state.image)
    }
}