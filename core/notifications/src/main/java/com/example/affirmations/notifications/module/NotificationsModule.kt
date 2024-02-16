package com.example.affirmations.core.notifications.module

import android.app.NotificationManager
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NotificationsModule {
    @Provides
    fun provideNotificationManager(@ApplicationContext context: Context): NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
}