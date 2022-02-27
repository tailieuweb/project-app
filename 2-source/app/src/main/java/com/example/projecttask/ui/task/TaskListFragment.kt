package com.example.projecttask.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecttask.databinding.FragmentTaskListBinding
import com.example.projecttask.ui.BaseFragment
import com.example.projecttask.ui.adapters.ItemListAdapter

class TaskListFragment : BaseFragment() {

    private lateinit var viewModel: TaskListViewModel
    private var _binding: FragmentTaskListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var adapter: ItemListAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = getViewModel(TaskListViewModel::class.java)

        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getTaskList()
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter = ItemListAdapter(it)
            binding.recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}