package com.app.webengage.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.webengage.localdatabaseservice.entities.PersonEntity
import com.app.webengage.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {

    private val checkAuth = MutableLiveData<List<PersonEntity>>()
    val checkAuthLiveData: LiveData<List<PersonEntity>>
        get() = checkAuth

    fun fetchAuthData(email: String, password: String) = viewModelScope.launch {
        checkAuth.postValue(mainRepository.checkAuth(email, password))
    }
}