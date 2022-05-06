package com.dartware.radiocamp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dartware.radiocamp.presentation.ui.theme.blockBackground

@Composable
fun Block(
	modifier: Modifier = Modifier,
	title: String? = null,
	description: String? = null,
	content: @Composable () -> Unit
) {
	Column(
		modifier = modifier
	) {

		title?.let {

			Text(
				text = it,
				fontWeight = FontWeight.Bold,
				fontSize = 20.sp
			)

			Spacer(modifier = Modifier.height(10.dp))

		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.clip(RoundedCornerShape(15.dp))
				.background(MaterialTheme.colors.blockBackground)
				.padding(
					vertical = 30.dp,
					horizontal = 15.dp
				)
		) {
			content()
		}

		description?.let {

			Spacer(modifier = Modifier.height(10.dp))

			Text(
				text = it,
				fontWeight = FontWeight.Normal,
				fontSize = 14.sp
			)

		}

	}
}