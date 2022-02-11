package com.example.projecttask.data

import com.example.projecttask.data.model.UserModel
import io.realm.Realm
import javax.inject.Inject


class MyDatabase @Inject constructor(){

    // TODO: save load user
    fun getUser(): UserModel? {
        val realm = Realm.getDefaultInstance()
        val user = realm.where(UserModel::class.java).findFirst()
        if (user != null) {
            return  realm.copyFromRealm(user)
        }

        return  null
    }
}