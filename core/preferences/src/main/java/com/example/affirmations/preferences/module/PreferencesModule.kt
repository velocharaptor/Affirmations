package com.example.affirmations.preferences.module

import android.content.SharedPreferences
import com.example.affirmations.utils.resmanager.ResManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PreferencesModule {
    @Provides
    fun providePreferences(resManager: ResManager): SharedPreferences {
        return resManager.getDefaultSharedPreferences()
    }
}