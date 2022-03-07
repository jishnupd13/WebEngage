package com.app.mymainapp.ui.login

import androidx.lifecycle.ViewModel
import com.app.mymainapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {
}