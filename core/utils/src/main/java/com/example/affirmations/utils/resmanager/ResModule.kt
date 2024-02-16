package com.example.affirmations.utils.resmanager

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ResModule {
    @Provides
    fun provideResManager(@ApplicationContext context: Context): ResManager {
        return ResManagerImpl(context)
    }
}