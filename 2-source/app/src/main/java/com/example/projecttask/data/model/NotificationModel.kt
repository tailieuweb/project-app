package com.example.projecttask.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class NotificationModel: RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var description: String = ""
}