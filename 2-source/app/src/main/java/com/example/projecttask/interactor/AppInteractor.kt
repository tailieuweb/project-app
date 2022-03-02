package com.example.projecttask.interactor

import com.example.projecttask.apis.TaskDetail
import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.data.model.NotificationModel
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

    fun getList(completion: ((List<TaskDetail>) -> Unit)?) {
        val user = repository.getUser()
        if (user == null) {
            completion?.invoke(listOf())
            return
        }
        webServiceApi.getList(userId = user.userId, token = user.token)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

                completion?.invoke(it)
            }, {
                completion?.invoke(listOf())
            })
    }

    fun getDetail(user_id: String,task_id: String, completion: ((WebServiceApi.DetailData?) -> Unit)?) {
        webServiceApi.getDetail(user_id, task_id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

                completion?.invoke(it)
            }, {
                completion?.invoke(null)
            })
    }

    fun submit(notes: String, done: Boolean) {
        // TODO: Handle post to webservice here
    }

    fun getNotifications(completion: ((List<NotificationModel>) -> Unit)?) {
        val notifications = repository.getNotifications()
        completion?.invoke(notifications)
    }

    fun saveNotification(notificationModel: NotificationModel) {
        repository.saveNotification(notificationModel)
    }

    init {
        // TODO: Interactor layer
    }

}
