package com.example.projecttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projecttask.MainActivity
import com.example.projecttask.databinding.FragmentLoginBinding
import com.example.projecttask.ui.BaseFragment

class LoginFragment : BaseFragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as? MainActivity)?.showOrHideBottomBar(isHidden = true)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        loginViewModel = getViewModel(LoginViewModel::class.java)

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            Toast.makeText(requireContext(), "Login...", Toast.LENGTH_LONG).show()
            val user = binding.usernameTextInput.editText?.text?.trim().toString()
            val pass = binding.passportTextInput.editText?.text?.trim().toString()

            loginViewModel.login(userName = user, password = pass) { success ->
                if (success) {
                    findNavController().navigateUp()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        (activity as? MainActivity)?.showOrHideBottomBar(isHidden = false)
    }
}