package com.example.projecttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projecttask.databinding.FragmentHomeBinding
import com.example.projecttask.databinding.FragmentTaskConfirmBinding
import com.example.projecttask.ui.BaseFragment

class TaskConfirmFragment : BaseFragment() {

    private lateinit var loginViewModel: TaskConfirmViewModel
    private var _binding: FragmentTaskConfirmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        loginViewModel = getViewModel(TaskConfirmViewModel::class.java)

        _binding = FragmentTaskConfirmBinding.inflate(inflater, container, false)
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