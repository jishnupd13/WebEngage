package com.app.mymainapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mymainapp.localdatabaseservice.entities.PersonEntity
import com.app.mymainapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {

    private val fetchPersonByWebEngageId = MutableLiveData<List<PersonEntity>>()
    val fetchPersonByWebEngageIdLiveData: LiveData<List<PersonEntity>>
        get() = fetchPersonByWebEngageId

    fun fetchPersonByWebEngageId(id: String) = viewModelScope.launch {
        fetchPersonByWebEngageId.postValue(mainRepository.fetchPersonsByWebEngageId(id))
    }
}