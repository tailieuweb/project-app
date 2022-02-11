package com.example.projecttask.interactor

import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.data.model.UserModel
import javax.inject.Inject

class AppInteractor @Inject constructor(
    val repository: MyRepository,
    val webServiceApi: WebServiceApi
)  {
    fun getUser(): UserModel? {
        return repository.getUser()
    }

    init {
        // TODO: Interactor layer
    }

}
