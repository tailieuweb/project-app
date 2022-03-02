package com.example.projecttask.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projecttask.databinding.FragmentTaskDetailBinding
import com.example.projecttask.ui.BaseFragment

class TaskDetailFragment : BaseFragment() {

    private lateinit var viewModel: TaskDetailViewModel
    private var _binding: FragmentTaskDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = getViewModel(TaskDetailViewModel::class.java)

        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskId = requireArguments().getString("id")
        Toast.makeText(requireContext(), "Display task details = ${taskId}", Toast.LENGTH_LONG).show()

        binding.button6.setOnClickListener {
            // TODO: Handle submit task detail changes here
            val notes = "ABC"
            val done = binding.checkboxTaskStatus.isChecked
            Toast.makeText(requireContext(), "We have not implemented it yet.", Toast.LENGTH_LONG).show()
            viewModel.submit(notes, done)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}