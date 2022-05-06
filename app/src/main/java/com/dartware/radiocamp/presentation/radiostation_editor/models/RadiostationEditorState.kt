package com.dartware.radiocamp.presentation.radiostation_editor.models

data class RadiostationEditorState(
    val title: String = "",
    val streamURL: String = "",
    val isValid: Boolean = false
)