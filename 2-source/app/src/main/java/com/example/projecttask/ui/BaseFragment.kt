package com.example.projecttask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projecttask.App
import com.example.projecttask.di.ViewModelFactory
import javax.inject.Inject

open class BaseFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelFactory

    fun <T : ViewModel?> getViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(this, factory).get(modelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as App)?.appComponent?.inject(this)
    }
}