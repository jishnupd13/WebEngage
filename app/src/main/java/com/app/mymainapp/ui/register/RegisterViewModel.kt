package com.app.mymainapp.ui.register

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
class RegisterViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {

    private val insertPersonData = MutableLiveData<Long>()
    val insertPersonLiveData: LiveData<Long>
        get() = insertPersonData

    private val fetchPersonList = MutableLiveData<List<PersonEntity>>()
    val fetchPersonListLiveData: LiveData<List<PersonEntity>>
        get() = fetchPersonList


    fun fetchPersonList() = viewModelScope.launch {
        fetchPersonList.postValue(mainRepository.fetchPersons())
    }

    fun insertPersonEntity(personEntity: PersonEntity) = viewModelScope.launch {
        insertPersonData.postValue(mainRepository.insertPerson(personEntity))
    }
}