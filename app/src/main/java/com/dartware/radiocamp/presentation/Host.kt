package com.dartware.radiocamp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dartware.radiocamp.presentation.bottom_player.views.BottomSheetView
import com.dartware.radiocamp.presentation.radiostations_list.screens.NavGraphs
import com.dartware.radiocamp.presentation.ui.theme.RadiocampTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@ExperimentalMaterialApi
@Composable
fun Host() {
	RadiocampTheme {
		Surface(
			modifier = Modifier
				.fillMaxSize(),
			color = MaterialTheme.colors.background
		) {

			val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
				bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
			)

			BottomSheetScaffold(
				scaffoldState = bottomSheetScaffoldState,
				sheetContent = {
					BottomSheetView()
				},
				sheetPeekHeight = 80.dp
			) {
				DestinationsNavHost(
					navGraph = NavGraphs.root
				)
			}

		}
	}
}