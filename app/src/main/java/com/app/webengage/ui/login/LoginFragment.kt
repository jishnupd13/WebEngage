package com.app.webengage.ui.login

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.webengage.R
import com.app.webengage.databinding.FragmentLoginBinding
import com.app.webengage.preferences.PreferenceHandler
import com.app.webengage.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.webengage.sdk.android.User
import com.webengage.sdk.android.WebEngage


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding()
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var preferenceHandler: PreferenceHandler
    private var weUser: User? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        weUser = WebEngage.get().user()

        binding.textViewRegisterLink.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.userName.text.toString().trim()
            val password = binding.userPassword.text.toString().trim()
            viewModel.fetchAuthData(email, password)
        }
        observeAuth()
    }

    private fun observeAuth() {
        viewModel.checkAuthLiveData.observe(viewLifecycleOwner, {
            if (it.isEmpty()) {
                requireContext().showToast("Email and password is incorrect")
            } else {
                preferenceHandler.webEngageId = it[0].webEngageId
               weUser?.login(preferenceHandler.webEngageId)

                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                )
            }
        })
    }
}