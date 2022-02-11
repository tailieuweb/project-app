package com.example.projecttask.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projecttask.interactor.AppInteractor
import com.example.projecttask.ui.home.HomeViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
        private val application: Application,
        private val interactor: AppInteractor
) : ViewModelProvider.NewInstanceFactory()  {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(application, interactor)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}