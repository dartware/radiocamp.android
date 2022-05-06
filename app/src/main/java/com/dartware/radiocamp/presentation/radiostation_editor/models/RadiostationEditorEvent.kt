package com.dartware.radiocamp.presentation.radiostation_editor.models

sealed class RadiostationEditorEvent {

    data class TitleChanged(
        val title: String
    ) : RadiostationEditorEvent()

    data class StreamURLChanged(
        val streamURL: String
    ) : RadiostationEditorEvent()

    object Submit : RadiostationEditorEvent()

}
