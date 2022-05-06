package com.dartware.radiocamp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dartware.radiocamp.presentation.ui.theme.simpleButtonForeground

@Composable
fun SimpleButton(
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	content: String? = null,
	isActive: Boolean = true
) {
	Box(
		modifier = modifier
			.clip(RoundedCornerShape(30.dp))
			.background(MaterialTheme.colors.primary.copy(alpha = if (isActive) 1f else 0.4f))
			.clickable(
				enabled = isActive
			) {
				onClick()
			},
		contentAlignment = Alignment.Center
	) {
		Box(
			modifier = Modifier
				.padding(
					horizontal = 10.dp,
					vertical = 7.dp
				)
		) {
			if (!content.isNullOrBlank()) {
				Text(
					modifier = Modifier
						.align(Alignment.Center),
					text = content,
					textAlign = TextAlign.Center,
					color = MaterialTheme.colors.simpleButtonForeground.copy(alpha = if (isActive) 1f else 0.4f)
				)
			}
		}
	}
}