package com.app.mymainapp.ui.origin

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.mymainapp.databinding.ActivityOriginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OriginActivity : AppCompatActivity() {

    private val binding: ActivityOriginBinding by viewBinding()
    private val viewModel: OriginActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }
}