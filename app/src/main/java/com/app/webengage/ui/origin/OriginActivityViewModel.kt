package com.app.webengage.ui.origin

import androidx.lifecycle.ViewModel
import com.app.webengage.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OriginActivityViewModel  @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel()  {
}