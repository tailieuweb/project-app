package com.example.projecttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projecttask.databinding.FragmentTaskDetailBinding
import com.example.projecttask.ui.BaseFragment

class TaskDetailFragment : BaseFragment() {

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
        loginViewModel = getViewModel(TaskDetailViewModel::class.java)

        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskId = requireArguments().getString("id")
        Toast.makeText(requireContext(), "Display task details = ${taskId}", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}