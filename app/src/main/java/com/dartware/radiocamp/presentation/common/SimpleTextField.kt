package com.dartware.radiocamp.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dartware.radiocamp.presentation.ui.theme.textFieldForeground
import com.dartware.radiocamp.presentation.ui.theme.textFieldIndicatorActive
import com.dartware.radiocamp.presentation.ui.theme.textFieldIndicatorInactive
import com.dartware.radiocamp.presentation.ui.theme.textFieldPlaceholder

@Composable
fun SimpleTextField(
	value: String,
	onValueChange: (String) -> Unit,
	description: String? = null,
	modifier: Modifier = Modifier,
	placeholder: String? = null,
	leadingIcon: (@Composable () -> Unit)? = null,
	trailingIcon: (@Composable () -> Unit)? = null,
	keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
	keyboardActions: KeyboardActions = KeyboardActions.Default
) {

	var isFocused by remember { mutableStateOf(false) }
	val textFieldIndicatorInactive = MaterialTheme.colors.textFieldIndicatorInactive
	val textFieldIndicatorActive = MaterialTheme.colors.textFieldIndicatorActive

	Box(
		modifier = modifier
			.fillMaxWidth()
			.drawBehind {

				val strokeWidth = 4f
				val y = size.height - strokeWidth / 2

				drawLine(
					color = if (isFocused) textFieldIndicatorActive else textFieldIndicatorInactive,
					Offset(0f, y),
					Offset(size.width, y),
					strokeWidth
				)

			}
			.padding(
				bottom = 10.dp
			)
	) {
		Column(
			modifier = modifier
				.fillMaxWidth()
		) {

			if (!description.isNullOrBlank()) {

				Text(
					text = description,
					color = MaterialTheme.colors.primary,
					fontSize = 14.sp
				)

				Spacer(modifier = Modifier.height(5.dp))

			}

			Box {

				BasicTextField(
					modifier = Modifier
						.fillMaxWidth()
						.onFocusChanged { isFocused = it.isFocused },
					value = value,
					onValueChange = onValueChange,
					textStyle = TextStyle(
						fontSize = 17.sp,
						color = MaterialTheme.colors.textFieldForeground
					),
					decorationBox = { innerTextField ->
						innerTextField()
					},
					cursorBrush = Brush.linearGradient(
						colors = listOf(
							MaterialTheme.colors.textFieldForeground,
							MaterialTheme.colors.textFieldForeground
						)
					),
					keyboardOptions = keyboardOptions,
					keyboardActions = keyboardActions
				)

				if (value.isBlank() && !placeholder.isNullOrBlank()) {
					Text(
						text = placeholder,
						fontSize = 17.sp,
						color = MaterialTheme.colors.textFieldPlaceholder
					)
				}

			}

		}
	}

}