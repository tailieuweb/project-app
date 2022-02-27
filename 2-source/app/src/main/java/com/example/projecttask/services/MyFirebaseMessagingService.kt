package com.example.projecttask.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import javax.inject.Inject

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        print("Data: ${remoteMessage.data}")
        print("Body: ${remoteMessage.notification?.body}" )


    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        print("Token : $token")

    }
}