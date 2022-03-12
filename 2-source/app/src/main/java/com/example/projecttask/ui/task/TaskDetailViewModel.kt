package com.example.projecttask.ui.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.projecttask.apis.TaskDetail
import com.example.projecttask.interactor.AppInteractor

class TaskDetailViewModel constructor(private val app: Application,
                                      private val interactor: AppInteractor
) : AndroidViewModel(app)  {
    fun submit(taskId: String, notes: String, taskStatus: String, completion: ((Boolean) -> Unit)?) {
        interactor.submit(taskId, notes, taskStatus, completion = completion)
    }

    val liveData: MutableLiveData<TaskDetail> = MutableLiveData()

    fun getDetail(taskId: String) {
        interactor.getDetail(taskId) {
            liveData.postValue(it)
        }
    }


}