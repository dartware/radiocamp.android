package com.dartware.radiocamp.presentation.radiostations_list.viewmodels

import androidx.lifecycle.ViewModel
import com.dartware.radiocamp.domain.repositories.RadiostationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RadiostationsListViewModel @Inject constructor(
	private val radiostationsRepository: RadiostationsRepository
) : ViewModel() {}