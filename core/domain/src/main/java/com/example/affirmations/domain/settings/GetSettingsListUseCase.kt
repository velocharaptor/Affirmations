package com.example.affirmations.domain.settings

import javax.inject.Inject

class GetSettingsListUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    suspend fun getSettingsList(): List<FeatureModel> {
        return repository.getSettingsList()
    }
}