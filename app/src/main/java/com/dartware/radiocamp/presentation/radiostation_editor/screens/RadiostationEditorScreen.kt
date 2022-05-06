package com.dartware.radiocamp.presentation.radiostation_editor.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dartware.radiocamp.R
import com.dartware.radiocamp.domain.models.Radiostation
import com.dartware.radiocamp.presentation.common.Block
import com.dartware.radiocamp.presentation.common.SimpleButton
import com.dartware.radiocamp.presentation.common.SimpleTextField
import com.dartware.radiocamp.presentation.radiostation_editor.models.RadiostationEditorEvent
import com.dartware.radiocamp.presentation.radiostation_editor.viewmodels.RadiostationEditorViewModel
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Composable
@Destination
fun RadiostationEditorScreen(
	navigator: DestinationsNavigator,
	radiostation: Radiostation? = null,
	viewModel: RadiostationEditorViewModel = hiltViewModel()
) {

	val state = viewModel.state

	val insestsPaddingValues = rememberInsetsPaddingValues(
		insets = LocalWindowInsets.current.ime,
		applyBottom = true
	)

	val keyboardController = LocalSoftwareKeyboardController.current
	val scrollState = rememberScrollState()

	Box(
		modifier = Modifier
			.fillMaxSize()
			.padding(insestsPaddingValues),
	) {
		Column(
			modifier = Modifier
				.padding(10.dp)
				.align(BottomCenter)
		) {

			Column(
				verticalArrangement = Arrangement.Bottom,
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.verticalScroll(
						enabled = true,
						state = scrollState,
						reverseScrolling = true
					)
					.weight(1f)
			) {

				Spacer(modifier = Modifier.height(30.dp))

				Block {
					Column(
						modifier = Modifier
							.fillMaxWidth()
					) {



						SimpleTextField(
							value = state.title,
							onValueChange = {
								viewModel.onEvent(RadiostationEditorEvent.TitleChanged(it))
							},
							description = stringResource(id = R.string.title),
							placeholder = stringResource(id = R.string.enter_title),
							keyboardOptions = KeyboardOptions(
								imeAction = ImeAction.Next
							)
						)

						Spacer(modifier = Modifier.height(20.dp))

						SimpleTextField(
							value = state.streamURL,
							onValueChange = {
								viewModel.onEvent(RadiostationEditorEvent.StreamURLChanged(it))
							},
							description = stringResource(id = R.string.stream_url),
							placeholder = stringResource(id = R.string.enter_stream_url),
							keyboardOptions = KeyboardOptions(
								imeAction = ImeAction.Done
							),
							keyboardActions = KeyboardActions {
								keyboardController?.hide()
								viewModel.onEvent(RadiostationEditorEvent.Submit)
								navigator.popBackStack()
							}
						)

					}
				}

			}

			Spacer(modifier = Modifier.height(30.dp))

			SimpleButton(
				onClick = {
					viewModel.onEvent(RadiostationEditorEvent.Submit)
					navigator.popBackStack()
				},
				modifier = Modifier
					.fillMaxWidth()
					.align(CenterHorizontally),
				content = stringResource(R.string.save),
				isActive = state.isValid
			)

			Spacer(modifier = Modifier.height(20.dp))

		}
	}

}