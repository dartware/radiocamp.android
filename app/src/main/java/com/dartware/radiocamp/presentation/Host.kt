package com.dartware.radiocamp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dartware.radiocamp.presentation.radiostations_list.screens.NavGraphs
import com.dartware.radiocamp.presentation.ui.theme.RadiocampTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun Host() {
	RadiocampTheme {
		Surface(
			modifier = Modifier
				.fillMaxSize(),
			color = MaterialTheme.colors.background
		) {
			DestinationsNavHost(
				navGraph = NavGraphs.root
			)
		}
	}
}