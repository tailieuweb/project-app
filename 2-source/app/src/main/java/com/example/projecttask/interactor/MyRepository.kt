package com.example.projecttask.interactor

import com.example.projecttask.data.MyDatabase
import java.util.*
import javax.inject.Inject

class  MyRepository @Inject constructor(private val DAO: MyDatabase) {
}