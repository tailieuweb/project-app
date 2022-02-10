package com.example.projecttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import com.example.projecttask.databinding.FragmentHomeBinding
import com.example.projecttask.databinding.FragmentTaskDetailBinding

class TaskDetailFragment : Fragment() {

    private lateinit var loginViewModel: TaskDetailViewModel
    private var _binding: FragmentTaskDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(TaskDetailViewModel::class.java)

        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        loginViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}