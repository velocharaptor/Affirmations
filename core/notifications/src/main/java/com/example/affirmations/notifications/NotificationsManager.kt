package com.example.affirmations.core.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.affirmations.notifications.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationsManager @Inject constructor(
    private val manager: NotificationManager,
    @ApplicationContext private val context : Context
) {
    @RequiresApi(Build.VERSION_CODES.O)
    @Suppress("DEPRECATION")
    fun showNotification(string: String) {
        val intent = Intent("")
        val pendingIntent = PendingIntent.getActivity(context, NOTIFY_ID, intent, PendingIntent.FLAG_MUTABLE)
        val channel = NotificationChannel(CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(channel)
        val notification = Notification.Builder(context, channel.id)
            .setContentTitle(string)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.message)
            .addAction(0, "Action", pendingIntent)
            .setAutoCancel(true)
            .build()
        manager.notify(NOTIFY_ID, notification)
    }

    companion object{
        const val NOTIFY_ID = 1001
        const val CHANNEL_ID = "101"
        const val channelName = "Channel 1"
    }
}