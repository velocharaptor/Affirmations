package com.example.affirmations.uikit.containeritem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.detmir.recycli.adapters.RecyclerAdapter
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R

@RecyclerItemView
class ContainerItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val recycler: RecyclerView
    private val recyclerAdapter: RecyclerAdapter

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.container_item, this, true)
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        recyclerAdapter = RecyclerAdapter()
        recycler = view.findViewById(R.id.recycler_container_recycler)

        recycler.run {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = recyclerAdapter
        }
    }

    @RecyclerItemStateBinder
    fun bindState(state: ContainerItem) {
        recyclerAdapter.bindState(state.recyclerState)
    }
}