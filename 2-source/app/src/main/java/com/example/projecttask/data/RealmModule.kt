package com.example.projecttask.data
import com.example.projecttask.data.model.UserModel
import io.realm.annotations.RealmModule

@RealmModule(classes = [
    UserModel::class,
])

class RealmModule {

}