package com.app.mymainapp.ui.register

import androidx.lifecycle.ViewModel
import com.app.mymainapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel()  {
}