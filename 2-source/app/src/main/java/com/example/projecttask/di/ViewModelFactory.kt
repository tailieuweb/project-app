package com.example.projecttask.di

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.projecttask.interactor.AppInteractor
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
        private val application: Application,
        private val interactor: AppInteractor
) : ViewModelProvider.NewInstanceFactory()  {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}