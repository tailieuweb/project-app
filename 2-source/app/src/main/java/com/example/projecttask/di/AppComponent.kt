package com.example.projecttask.di

import com.example.projecttask.App
import com.example.projecttask.services.MyFirebaseMessagingService
import com.example.projecttask.ui.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Component(
        modules = [
            AndroidModule::class,
            AppModule::class,
            DataModule::class
        ])
@Singleton
interface AppComponent {
    fun inject(app: App)
    fun inject(into: BaseFragment)
    fun inject(into: MyFirebaseMessagingService)
}