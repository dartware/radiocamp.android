package com.dartware.radiocamp.presentation.radiostations_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dartware.radiocamp.domain.models.Radiostation

@Composable
fun RadiostationsListItem(
	radiostation: Radiostation,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
	) {

		Text(
			radiostation.title
		)

		Text(
			radiostation.streamURL
		)

	}
}