package com.example.affirmations.data.settings

import com.example.affirmations.domain.settings.FeatureModel
import com.example.affirmations.domain.settings.SettingsRepository
import com.example.affirmations.preferences.Preferences

class SettingsRepositoryImpl(
    private val preferences: Preferences
    ) : SettingsRepository {

    override suspend fun getSettingsList(): List<FeatureModel> {
        val listFeatureFlags = com.example.affirmations.featureflag.features.FeatureFlag.getFeatures()

        return listFeatureFlags.map { featureFlag ->
            FeatureModel(
                title = featureFlag.title,
                key = featureFlag.key,
                description = " ",
                isEnabled = preferences.getBoolean(featureFlag.key)
            )
        }
    }

    override suspend fun setFeatureIsEnabled(key: String, value: Boolean) {
        preferences.putBoolean(key, value)
    }
}