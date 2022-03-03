package com.example.projecttask.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.projecttask.interactor.AppInteractor
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class LoginViewModel constructor(private val app: Application,
                                 private val interactor: AppInteractor
) : AndroidViewModel(app)  {
    fun login(userName: String, password: String, completion: ((Boolean) -> Unit)?) {
        getDeviceToken { deviceToken ->
            interactor.login(userName, password, deviceToken, completion = completion)
        }

    }

    private fun getDeviceToken(completion: ((String) -> Unit)) {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                print("Get token error = ${task.exception}")
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            completion.invoke(token)
        })
    }
}