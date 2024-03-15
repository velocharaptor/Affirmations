package com.example.affirmations.feature.settings

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.detmir.recycli.adapters.RecyclerItem
import com.example.affirmations.core.notifications.NotificationsManager
import com.example.affirmations.domain.settings.GetSettingsListUseCase
import com.example.affirmations.domain.settings.SetFeatureIsEnabledUseCase
import com.example.affirmations.uikit.button.ButtonItem
import com.example.affirmations.uikit.settingsitem.SettingsItem
import com.example.affirmations.utils.Log
import com.example.affirmations.utils.resmanager.ResManager
import com.example.settings.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsListUseCase: GetSettingsListUseCase,
    private val setFeatureIsEnabledUseCase: SetFeatureIsEnabledUseCase,
    private val resManager: ResManager,
    private val notificationManager: NotificationsManager
) : ViewModel() {
    val data: MutableLiveData<List<RecyclerItem>> = MutableLiveData(emptyList())

    init {
        Log.log(TAG, "init")
    }

    fun loadSettings() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                settingsListUseCase.getSettingsList()
            }.onSuccess { listFeatures ->
                launch(Dispatchers.Main) {
                    val list: MutableList<RecyclerItem> = mutableListOf()
                    listFeatures.forEach { feature ->
                        list.add(
                            SettingsItem(
                                id = feature.key,
                                title = feature.title,
                                description = feature.description,
                                key = feature.key,
                                isEnabled = feature.isEnabled,
                                action = ::changeSettings
                            )
                        )
                    }
                    list.add(
                        ButtonItem(
                            id = "Notification_Button",
                            title = "Send notification",
                            action = ::sendNotification
                        )
                    )
                    data.value = list
                }
            }.onFailure {
                resManager.showToast(R.string.error, Toast.LENGTH_SHORT)
            }
        }
    }

    private fun changeSettings(key: String, value: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                setFeatureIsEnabledUseCase.setFeatureIsEnabled(key, value)
            }.onSuccess {
                loadSettings()
            }.onFailure {
                resManager.showToast(R.string.error, Toast.LENGTH_SHORT)
            }
        }
    }

    private fun sendNotification(data: RecyclerItem) {
        notificationManager.showNotification("Hello, world!")
    }

    companion object {
        private const val TAG = "SettingsViewModel"
    }
}