package com.example.projecttask.interactor

import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.data.model.UserModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AppInteractor @Inject constructor(
    val repository: MyRepository,
    val webServiceApi: WebServiceApi
)  {
    fun getUser(): UserModel? {
        return repository.getUser()
    }

    fun login(userName: String, password: String, completion: ((Boolean) -> Unit)?) {
        webServiceApi.login(userName, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                // TODO: Save user data
                print("userData = ${it}")
                repository.saveUser(it)
                completion?.invoke(true)
            }, {
                completion?.invoke(false)
            })
    }

    fun getList(completion: ((List<WebServiceApi.ListData>) -> Unit)?) {
        webServiceApi.getList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

                completion?.invoke(it)
            }, {
                completion?.invoke(listOf())
            })
    }

    fun getDetail(id: String, completion: ((WebServiceApi.DetailData?) -> Unit)?) {
        webServiceApi.getDetail(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

                completion?.invoke(it)
            }, {
                completion?.invoke(null)
            })
    }

    init {
        // TODO: Interactor layer
    }

}
