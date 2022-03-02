package com.example.projecttask.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projecttask.apis.TaskDetail
import com.example.projecttask.data.model.NotificationModel
import com.example.projecttask.interactor.AppInteractor

class NotificationsViewModel constructor(private val app: Application,
                                         private val interactor: AppInteractor
) : AndroidViewModel(app)  {

    val liveData: MutableLiveData<List<NotificationModel>> = MutableLiveData()

    fun getNotifications() {
        interactor.getNotifications {
            liveData.postValue(it)
        }
    }
}