package com.dartware.radiocamp.presentation.radiostations_list.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.dartware.radiocamp.presentation.radiostations_list.viewmodels.RadiostationsListViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination(start = true)
fun RadiostationsListScreen(
	viewModel: RadiostationsListViewModel = hiltViewModel()
) {}