package com.app.mymainapp.ui.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.mymainapp.R
import com.app.mymainapp.databinding.FragmentSplashScreenBinding
import com.app.mymainapp.preferences.PreferenceHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    private val binding: FragmentSplashScreenBinding by viewBinding()
    private val viewModel: SplashScreenViewModel by viewModels()

    @Inject
    lateinit var preferenceHandler: PreferenceHandler


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        lifecycleScope.launch {
            delay(3000)
            if (preferenceHandler.webEngageId.isEmpty()) {
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToLoginFragment())
            } else {
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeFragment())
            }
        }
    }
}