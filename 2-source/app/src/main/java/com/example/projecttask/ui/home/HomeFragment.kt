package com.example.projecttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projecttask.R
import com.example.projecttask.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

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
        homeViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Text view
        val textView: TextView = binding.textHome
        textView.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_loginFragment)
        }

        //Button login
//        binding.button.setOnClickListener{
//            val message = "Test button login"
//            Toast.makeText(this.context,message,Toast.LENGTH_LONG).show()
//
//        }
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
            findNavController().navigate(R.id.action_navigation_home_to_loginFragment)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}