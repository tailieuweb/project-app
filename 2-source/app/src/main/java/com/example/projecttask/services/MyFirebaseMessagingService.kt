package com.example.projecttask.services

import android.util.Log
import com.example.projecttask.App
import com.example.projecttask.data.model.NotificationModel
import com.example.projecttask.interactor.AppInteractor
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import javax.inject.Inject

class MyFirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var selfInteractor: AppInteractor

    override fun onCreate() {
        super.onCreate()

        (application as App).appComponent.inject(this)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        print("Data: ${remoteMessage.data}")
        print("Body: ${remoteMessage.notification?.body}" )

        // TODO: save notification to my database
        val notificationModel = NotificationModel()

        val body = remoteMessage.data.get("body")
        val title = remoteMessage.data.get("title")
        val taskId = remoteMessage.data.get("task_id")
        notificationModel.title  = title ?: ""
        notificationModel.description  = body ?: ""
        notificationModel.taskId  = taskId ?: ""

        selfInteractor.saveNotification(notificationModel)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        print("Token : $token")

    }
}