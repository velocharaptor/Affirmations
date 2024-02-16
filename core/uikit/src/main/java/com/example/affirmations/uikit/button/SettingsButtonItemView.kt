package com.example.affirmations.uikit.button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R

@RecyclerItemView
class SettingsButtonItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val button: Button
    private var settingsButton: SettingsButton? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.settings_button, this)
        button = findViewById(R.id.button_settings)
        button.setOnClickListener {
            settingsButton?.let { data->
                data.action.invoke()
            }
        }
    }

    @RecyclerItemStateBinder
    fun bindState(settingsButton: SettingsButton) {
        this.settingsButton = settingsButton
        button.text = settingsButton.title
    }
}