package com.example.projecttask

import android.app.Application
import com.example.projecttask.data.DbMigration
import com.example.projecttask.data.RealmModule
import com.example.projecttask.di.*
import com.example.projecttask.interactor.AppInteractor
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class App : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .androidModule(AndroidModule(this))
        .appModule(AppModule(this))
        .dataModule(DataModule())
        .build()

    @Inject
    lateinit var interactor: AppInteractor

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        instance = this

        // Config Realm db
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("default.realm")
                //.encryptionKey(key) /*No support at the moment*/
                .schemaVersion(1)
                .modules(RealmModule())
                .migration(DbMigration())
                .build()
        Realm.setDefaultConfiguration(config)
    }

    override fun onTerminate() {
        super.onTerminate()

    }
}