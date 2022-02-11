package com.example.projecttask.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projecttask.interactor.AppInteractor

class NotificationsViewModel constructor(private val app: Application,
                                         private val interactor: AppInteractor
) : AndroidViewModel(app)  {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}