package com.example.projecttask.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class UserModel: RealmObject() {
    @PrimaryKey
    var userId: String = UUID.randomUUID().toString()
    var email: String = ""
    var user_name: String = ""
    var token: String = ""
    var isAuthenticated: Boolean = false
}