package com.example.projecttask.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projecttask.interactor.AppInteractor
import com.example.projecttask.ui.dashboard.DashboardViewModel
import com.example.projecttask.ui.home.*
import com.example.projecttask.ui.notifications.NotificationsViewModel
import com.example.projecttask.ui.task.TaskListViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
        private val application: Application,
        private val interactor: AppInteractor
) : ViewModelProvider.NewInstanceFactory()  {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(application, interactor)
                isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(application, interactor)
                isAssignableFrom(DashboardViewModel::class.java) -> DashboardViewModel(application, interactor)
                isAssignableFrom(ForgotPasswordViewModel::class.java) -> ForgotPasswordViewModel(application, interactor)
                isAssignableFrom(TaskListViewModel::class.java) -> TaskListViewModel(application, interactor)
                isAssignableFrom(TaskConfirmViewModel::class.java) -> TaskConfirmViewModel(application, interactor)
                isAssignableFrom(NotificationsViewModel::class.java) -> NotificationsViewModel(application, interactor)
                isAssignableFrom(TaskDetailViewModel::class.java) -> TaskDetailViewModel(application, interactor)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}