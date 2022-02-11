package com.example.projecttask.di

import com.example.projecttask.App
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
    fun inject(BaseFragment)
}