package com.dartware.radiocamp.presentation.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val backgroundDark = Color(0xFF010101)
val backgroundLight = Color(0xFFf6f6f6)

val primaryDark = Color(0xFF0381fe)
val primaryLight = Color(0xFF0381fe)

val primaryVariantDark = Color(0xFF3700B3)
val primaryVariantLight = Color(0xFF3700B3)

val secondaryDark = Color(0xFF03DAC5)
val secondaryLight = Color(0xFF03DAC5)

val blockBackgroundDark = Color(0xFF171717)
val blockBackgroundLight = Color(0xFFfcfcfc)

val textFieldForegroundDark = Color(0xFFfafafa)
val textFieldForegroundLight = Color(0xFF010101)

val textFieldIndicatorInactiveDark = Color(0xFF999999)
val textFieldIndicatorInactiveLight = Color(0xFF8c8c8c)

val textFieldIndicatorActiveDark = Color(0xFF0381fe)
val textFieldIndicatorActiveLight = Color(0xFF0381fe)

val textFieldPlaceholderDark = Color(0xFF999999)
val textFieldPlaceholderLight = Color(0xFF8c8c8c)

val simpleButtonForegroundDark = Color(0xFFf6f6f6)
val simpleButtonForegroundLight = Color(0xFFf6f6f6)

@get:Composable
val Colors.blockBackground: Color
	get() = if (isLight) blockBackgroundLight else blockBackgroundDark

@get:Composable
val Colors.textFieldForeground: Color
	get() = if (isLight) textFieldForegroundLight else textFieldForegroundDark

@get:Composable
val Colors.textFieldIndicatorInactive: Color
	get() = if (isLight) textFieldIndicatorInactiveLight else textFieldIndicatorInactiveDark

@get:Composable
val Colors.textFieldIndicatorActive: Color
	get() = if (isLight) textFieldIndicatorActiveLight else textFieldIndicatorActiveDark

@get:Composable
val Colors.textFieldPlaceholder: Color
	get() = if (isLight) textFieldPlaceholderLight else textFieldPlaceholderDark

@get:Composable
val Colors.simpleButtonForeground: Color
	get() = if (isLight) simpleButtonForegroundLight else simpleButtonForegroundDark