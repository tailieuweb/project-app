package com.example.projecttask.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projecttask.interactor.AppInteractor

class TaskDetailViewModel constructor(private val app: Application,
                                      private val interactor: AppInteractor
) : AndroidViewModel(app)  {

    private val _text = MutableLiveData<String>().apply {
        value = "This is login Fragment"
    }
    val text: LiveData<String> = _text
}