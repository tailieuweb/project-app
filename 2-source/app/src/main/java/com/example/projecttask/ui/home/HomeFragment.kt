package com.example.projecttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.projecttask.R
import com.example.projecttask.ui.BaseFragment
import com.example.projecttask.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = getViewModel(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.requireLogin.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                findNavController().navigate(R.id.action_navigation_home_to_loginFragment)
            }
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getUserInfo()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}