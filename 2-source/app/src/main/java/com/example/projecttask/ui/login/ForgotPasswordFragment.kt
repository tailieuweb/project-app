package com.example.projecttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import com.example.projecttask.databinding.FragmentForgotPasswordBinding
import com.example.projecttask.databinding.FragmentLoginBinding

class ForgotPasswordFragment : Fragment() {

    private lateinit var forgotPasswordViewModel: ForgotPasswordViewModel
    private var _binding: FragmentForgotPasswordBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        forgotPasswordViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ForgotPasswordViewModel::class.java)

        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
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