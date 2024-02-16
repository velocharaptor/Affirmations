package com.example.affirmations.core.notifications

import com.example.affirmations.utils.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PushMessagingService : FirebaseMessagingService() {
    @Inject lateinit var manager: NotificationsManager

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        remoteMessage.notification?.let { notification ->
            manager.showNotification(notification.title ?: "")
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.log(TAG, token)
    }

    companion object{
        const val TAG = "TOKEN"
    }
}