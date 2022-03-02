package com.example.projecttask.ui.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.projecttask.interactor.AppInteractor

class TaskDetailViewModel constructor(private val app: Application,
                                      private val interactor: AppInteractor
) : AndroidViewModel(app)  {
    fun submit(notes: String, done: Boolean) {
        interactor.submit(notes, done)
    }


}