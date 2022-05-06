package com.dartware.radiocamp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.dartware.radiocamp.R
import com.dartware.radiocamp.presentation.bottom_player.views.BottomSheetView
import com.dartware.radiocamp.presentation.ui.theme.RadiocampTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.ramcosta.composedestinations.DestinationsNavHost

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Host() {

	RadiocampTheme() {
		ProvideWindowInsets(
			windowInsetsAnimationsEnabled = true
		) {
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
					sheetPeekHeight = dimensionResource(id = R.dimen.bottom_section_height),
				) {
					DestinationsNavHost(
						navGraph = NavGraphs.root,
						modifier = Modifier
							.padding(
								bottom = dimensionResource(id = R.dimen.bottom_section_height)
							)
					)
				}

			}
		}
	}

}