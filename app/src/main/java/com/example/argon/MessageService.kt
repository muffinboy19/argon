package com.example.argon

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessageService:FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        pushNotification(
            message.notification?.title,
            message.notification?.body)
    }

    private fun pushNotification(title:String?, msg:String?) {

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("refreshMsg",token)
    }
}