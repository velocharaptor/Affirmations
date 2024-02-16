package com.example.affirmations.uikit.homeitem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.uikit.ext.load

@RecyclerItemView
class HomeItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val text: TextView
    private val image: ImageView
    private var homeItem: HomeItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.home_item, this)
        text = findViewById(R.id.home_item_title)
        image = findViewById(R.id.home_item_image)
    }

    @RecyclerItemStateBinder
    fun bindState(homeItem: HomeItem){
        this.homeItem = homeItem
        text.text = homeItem.title
        image.load(homeItem.images)
    }
}