package com.app.webengage.service

import android.annotation.SuppressLint
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.webengage.sdk.android.WebEngage
import timber.log.Timber


@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        WebEngage.get().setRegistrationID(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val data: Map<String, String> = remoteMessage.data

        Timber.e("#### Received the push notification data")

        if (data.containsKey("source") && "webengage" == data["source"]) {
            WebEngage.get().receive(data)
        }
    }
}