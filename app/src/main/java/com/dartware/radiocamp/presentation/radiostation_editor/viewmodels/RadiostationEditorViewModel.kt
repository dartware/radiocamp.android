package com.dartware.radiocamp.presentation.radiostation_editor.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dartware.radiocamp.domain.models.Radiostation
import com.dartware.radiocamp.domain.use_cases.radiostations.SaveRadiostationUseCase
import com.dartware.radiocamp.presentation.radiostation_editor.models.RadiostationEditorEvent
import com.dartware.radiocamp.presentation.radiostation_editor.models.RadiostationEditorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RadiostationEditorViewModel @Inject constructor(
	private val savedStateHandle: SavedStateHandle,
	private val saveRadiostationUseCase: SaveRadiostationUseCase
) : ViewModel() {

	var state by mutableStateOf(RadiostationEditorState())

	fun onEvent(event: RadiostationEditorEvent) {
		when(event) {
			is RadiostationEditorEvent.TitleChanged -> onTitleChanged(event)
			is RadiostationEditorEvent.StreamURLChanged -> onStreamURLChanged(event)
			is RadiostationEditorEvent.Submit -> submit()
		}
	}

	private fun onTitleChanged(event: RadiostationEditorEvent.TitleChanged) {

		state = state.copy(
			title = event.title
		)

		validate()

	}

	private fun onStreamURLChanged(event: RadiostationEditorEvent.StreamURLChanged) {

		state = state.copy(
			streamURL = event.streamURL
		)

		validate()

	}

	private fun submit() {
		viewModelScope.launch {
			saveRadiostationUseCase(Radiostation(
				title = state.title,
				streamURL = state.streamURL,
				id = null
			))
		}
	}

	private fun validate() {

		val isValid = state.title.isNotBlank() && state.streamURL.isNotBlank()

		state = state.copy(
			isValid = isValid
		)

	}

}