package com.example.affirmations.domain.settings

import javax.inject.Inject

class SetFeatureIsEnabledUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend fun setFeatureIsEnabled(key: String, value: Boolean) {
        //repository.setFeatureIsEnabled(key, value)
    }
}