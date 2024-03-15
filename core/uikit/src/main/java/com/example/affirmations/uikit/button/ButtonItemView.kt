package com.example.affirmations.uikit.button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.example.affirmations.utils.applyMargin

@RecyclerItemView
class ButtonItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val button: Button
    private var settingsButton: ButtonItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.settings_button, this)
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        applyMargin(4)
        button = findViewById(R.id.button_settings)
        button.setOnClickListener {
            settingsButton?.let { data ->
                data.action.invoke(data)
            }
        }
    }

    @RecyclerItemStateBinder
    fun bindState(settingsButton: ButtonItem) {
        this.settingsButton = settingsButton
        button.text = settingsButton.title

        setSize(settingsButton.size)
    }

    private fun setSize(size: ButtonSize) {
         when (size) {
            ButtonSize.BIG -> {
                layoutParams.height = LayoutParams.WRAP_CONTENT
                layoutParams.width = LayoutParams.MATCH_PARENT
            }
            ButtonSize.SMALL -> {
                layoutParams.height = LayoutParams.WRAP_CONTENT
                layoutParams.width = LayoutParams.WRAP_CONTENT
            }
        }
    }
}