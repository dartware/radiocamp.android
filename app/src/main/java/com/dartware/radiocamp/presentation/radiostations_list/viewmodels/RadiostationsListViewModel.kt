package com.dartware.radiocamp.presentation.radiostations_list.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dartware.radiocamp.core.Resource
import com.dartware.radiocamp.domain.repositories.RadiostationsRepository
import com.dartware.radiocamp.presentation.radiostations_list.models.RadiostationsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RadiostationsListViewModel @Inject constructor(
	private val repository: RadiostationsRepository
) : ViewModel() {

	var state by mutableStateOf(RadiostationsListState())

	init {
		getRadiostationsList()
	}

	private fun getRadiostationsList() {
		viewModelScope.launch {
			repository.getAll().collect { result ->
				when(result) {
					is Resource.Success -> {
						result.data?.let { radiostations ->
							state = state.copy(
								radiostations = radiostations
							)
						}
					}
					is Resource.Error -> Unit
					is Resource.Loading -> {
						state = state.copy(
							isLoading = result.isLoading
						)
					}
				}
			}
		}
	}

}