package com.dartware.radiocamp.presentation.radiostations_list.models

import com.dartware.radiocamp.domain.models.Radiostation

data class RadiostationsListState(
	val radiostations: List<Radiostation> = emptyList(),
	val isLoading: Boolean = false,
	var searchQuery: String = ""
)