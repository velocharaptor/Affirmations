package com.example.affirmations.domain.settings

interface SettingsRepository {
    suspend fun getSettingsList(): List<FeatureModel>

    suspend fun setFeatureIsEnabled(key: String, value: Boolean)
}

