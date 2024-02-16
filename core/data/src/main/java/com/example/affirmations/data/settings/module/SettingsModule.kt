package com.example.affirmations.data.settings.module

import com.example.affirmations.domain.settings.SettingsRepository
import com.example.affirmations.data.settings.SettingsRepositoryImpl
import com.example.affirmations.preferences.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SettingsModule {
    @Provides
    fun provideSettingsRepository(preferences: Preferences): SettingsRepository {
        return SettingsRepositoryImpl(preferences)
    }
}