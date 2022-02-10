package com.example.projecttask.interactor

import com.example.projecttask.apis.WebServiceApi
import javax.inject.Inject

class AppInteractor @Inject constructor(
    val repository: MyRepository,
    val webServiceApi: WebServiceApi
)  {

    init {
        // TODO: Interactor layer
    }

}
