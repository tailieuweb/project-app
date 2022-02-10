package com.example.projecttask.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class UserModel: RealmObject() {
    @PrimaryKey
    var userId: String = UUID.randomUUID().toString()
}