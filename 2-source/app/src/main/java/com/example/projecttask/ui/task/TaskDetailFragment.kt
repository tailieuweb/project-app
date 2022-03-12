package com.example.projecttask.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.projecttask.R
import com.example.projecttask.databinding.FragmentTaskDetailBinding
import com.example.projecttask.ui.BaseFragment
import com.example.projecttask.ui.adapters.ItemListAdapter

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

        val taskId = requireArguments().getString("id") ?: ""
        /**
         *
         */
        viewModel.getDetail(taskId)
        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.tvStartDate.text = it.tasks.task_start_date
            binding.tvEndDate.text = it.tasks.task_end_date
            binding.tvTaskTitle.text = it.tasks.task_name
            
            binding.taskDescriptionInputTextLayout.editText?.setText(it.notes)
        }
        /*
        *
         */
        Toast.makeText(requireContext(), "Display task details = ${taskId}", Toast.LENGTH_LONG).show()

        val taskValues = resources.getStringArray(R.array.taskValues)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, taskValues)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                Toast.makeText(requireContext(), taskValues[position], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.spinner.adapter = adapter
        binding.button6.setOnClickListener {
            // TODO: Handle submit task detail changes here
            val taskDescription = binding.taskDescriptionInputTextLayout.editText?.text?.trim().toString()

            val taskStatus = taskValues[binding.spinner.selectedItemPosition]

            viewModel.submit(taskId = taskId, taskDescription, taskStatus) { success ->
                Toast.makeText(requireContext(), "Save task = ${success}.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}