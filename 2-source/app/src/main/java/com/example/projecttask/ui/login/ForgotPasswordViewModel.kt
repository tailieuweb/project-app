package com.example.projecttask.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ForgotPasswordViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is forgot password Fragment"
    }
    val text: LiveData<String> = _text
}