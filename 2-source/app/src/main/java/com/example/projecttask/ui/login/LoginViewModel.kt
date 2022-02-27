package com.example.projecttask.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projecttask.interactor.AppInteractor

class LoginViewModel constructor(private val app: Application,
                                 private val interactor: AppInteractor
) : AndroidViewModel(app)  {
    fun login(userName: String, password: String, completion: ((Boolean) -> Unit)?) {
        interactor.login(userName, password, completion = completion)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is login Fragment"
    }
    val text: LiveData<String> = _text
}