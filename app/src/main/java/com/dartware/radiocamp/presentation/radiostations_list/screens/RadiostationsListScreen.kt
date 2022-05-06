package com.dartware.radiocamp.presentation.radiostations_list.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dartware.radiocamp.R
import com.dartware.radiocamp.presentation.destinations.RadiostationEditorScreenDestination
import com.dartware.radiocamp.presentation.radiostations_list.components.RadiostationsListItem
import com.dartware.radiocamp.presentation.radiostations_list.viewmodels.RadiostationsListViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
@ExperimentalComposeUiApi
fun RadiostationsListScreen(
	navigator: DestinationsNavigator,
	viewModel: RadiostationsListViewModel = hiltViewModel()
) {

	val state = viewModel.state
	val scaffoldState = rememberScaffoldState()

	Scaffold(
		scaffoldState = scaffoldState,
		floatingActionButton = {
			FloatingActionButton(
				onClick = {
					  navigator.navigate(RadiostationEditorScreenDestination())
				}
			) {
				Icon(
					imageVector = Icons.Filled.Add,
					contentDescription = stringResource(R.string.add)
				)
			}
		},
		modifier = Modifier
			.fillMaxSize()
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
		) {

			OutlinedTextField(
				value = state.searchQuery,
				onValueChange = {},
				modifier = Modifier
					.padding(16.dp, 16.dp, 16.dp, 16.dp)
					.fillMaxWidth(),
				placeholder = {
					Text(text = stringResource(id = R.string.search))
				},
				maxLines = 1,
				singleLine = true
			)

			LazyColumn(
				modifier = Modifier
					.fillMaxSize()
			) {

				items(
					count = state.radiostations.size
				) { index ->

					val radiostation = state.radiostations[index]

					RadiostationsListItem(
						radiostation = radiostation,
						modifier = Modifier.fillMaxWidth()
					)

					if (index < state.radiostations.size) {
						Divider(
							modifier = Modifier
								.padding(
									horizontal = 16.dp
								)
						)
					}

				}

			}

		}
	}

}