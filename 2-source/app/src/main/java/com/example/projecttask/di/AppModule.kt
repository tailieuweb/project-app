package com.example.projecttask.di

import android.app.Application
import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.data.MyDatabase
import com.example.projecttask.interactor.AppInteractor
import com.example.projecttask.interactor.MyRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Singleton
    @Provides
    fun provideRepository(database: MyDatabase) = MyRepository(database)

    @Singleton
    @Provides
    fun provideInteractor(repository: MyRepository, webServiceApi: WebServiceApi) = AppInteractor(repository, webServiceApi)

    @Singleton
    @Provides
    fun provideViewModelFactory(interactor: AppInteractor) = ViewModelFactory(application, interactor)

}