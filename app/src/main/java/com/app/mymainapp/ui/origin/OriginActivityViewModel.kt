package com.app.mymainapp.ui.origin

import androidx.lifecycle.ViewModel
import com.app.mymainapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OriginActivityViewModel  @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel()  {
}