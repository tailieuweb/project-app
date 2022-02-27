package com.example.projecttask.ui.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.interactor.AppInteractor

class TaskListViewModel constructor(private val app: Application,
                                    private val interactor: AppInteractor
) : AndroidViewModel(app)  {

    val liveData: MutableLiveData<List<WebServiceApi.ListData>> = MutableLiveData()

    fun getTaskList() {
        interactor.getList {
            liveData.postValue(it)
        }
    }
}