package com.example.projecttask.interactor

import com.example.projecttask.data.MyDatabase
import com.example.projecttask.data.model.UserModel
import java.util.*
import javax.inject.Inject

class  MyRepository @Inject constructor(private val DAO: MyDatabase) {
    fun getUser(): UserModel? {
        return  DAO.getUser()
    }
}