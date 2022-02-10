package com.example.projecttask.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return context.applicationContext as Application
    }
}