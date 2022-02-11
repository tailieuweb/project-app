package com.example.projecttask.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projecttask.interactor.AppInteractor

class HomeViewModel constructor(private val app: Application,
                                private val interactor: AppInteractor) : AndroidViewModel(app) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        val user = interactor.getUser()

        user?.isAuthenticated?.let { isAuthenticated ->
            requireLogin.apply {
                !isAuthenticated
            }
        }
    }
    val requireLogin: LiveData<Boolean> = MutableLiveData()


}