package com.dartware.radiocamp.presentation.bottom_player.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.dartware.radiocamp.presentation.bottom_player.viewmodels.BottomSheetViewModel

@Composable
fun BottomSheetView(
	viewModel: BottomSheetViewModel = hiltViewModel()
) {
	Box(
		modifier = Modifier
			.fillMaxSize()
	) {
		Text(
			text = "Bottom player"
		)
	}
}