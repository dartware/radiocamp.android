package com.dartware.radiocamp.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dartware.radiocamp.presentation.Host
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)

		setContent {
			Host()
		}

	}
}