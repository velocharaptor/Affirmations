package com.example.affirmations.uikit.settingsitem

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.detmir.recycli.annotations.RecyclerItemStateBinder
import com.detmir.recycli.annotations.RecyclerItemView
import com.example.affirmations.uikit.R
import com.google.android.material.materialswitch.MaterialSwitch

@RecyclerItemView
class SettingsItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val textView: TextView
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private val switch: MaterialSwitch
    private var settingsItem: SettingsItem? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.settings_item, this)
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        textView = findViewById(R.id.settings_title)
        switch = findViewById(R.id.setting_switch)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            settingsItem?.let { setting ->
                setting.action.invoke(setting.key, !setting.isEnabled)
            }
        }
    }

    @RecyclerItemStateBinder
    fun bindState(state: SettingsItem) {
        settingsItem = state
        textView.text = state.title
        switch.isChecked = state.isEnabled
    }
}