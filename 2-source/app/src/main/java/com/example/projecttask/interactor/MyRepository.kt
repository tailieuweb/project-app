package com.example.projecttask.interactor

import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.data.MyDatabase
import com.example.projecttask.data.model.UserModel
import java.util.*
import javax.inject.Inject

class  MyRepository @Inject constructor(private val DAO: MyDatabase) {
    fun getUser(): UserModel? {
        return  DAO.getUser()
    }

    fun saveUser(userData: WebServiceApi.LoginData) {
        val userModel = UserModel()
        userModel.userId = userData.user.id
        userModel.email = userData.user.email
        userModel.user_name = userData.user.user_name
        userModel.token = userData.token
        userModel.isAuthenticated = true

        DAO.saveUser(userModel)
    }
}