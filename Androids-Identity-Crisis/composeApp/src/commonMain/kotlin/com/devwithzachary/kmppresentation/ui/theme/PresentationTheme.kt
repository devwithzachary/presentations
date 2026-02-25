package com.devwithzachary.kmppresentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp

@Composable
fun ResponsivePresentationTheme(
    windowWidth: Dp,
    windowHeight: Dp,
    content: @Composable () -> Unit
) {
    val baseReferenceWidth = 1920f
    val baseReferenceHeight = 1080f
    val baseBoost = 1.5f

    val scale = remember(windowWidth, windowHeight) {
        val widthRatio = windowWidth.value / baseReferenceWidth
        val heightRatio = windowHeight.value / baseReferenceHeight

        minOf(widthRatio, heightRatio) * baseBoost
    }

    val baseTypography = MaterialTheme.typography

    // 2. Generate Scaled Typography
    val responsiveTypography = remember(scale) {
        Typography(
            displayLarge = baseTypography.displayLarge.scale(scale),
            displayMedium = baseTypography.displayMedium.scale(scale),
            displaySmall = baseTypography.displaySmall.scale(scale),
            headlineLarge = baseTypography.headlineLarge.scale(scale),
            headlineMedium = baseTypography.headlineMedium.scale(scale),
            headlineSmall = baseTypography.headlineSmall.scale(scale),
            titleLarge = baseTypography.titleLarge.scale(scale),
            titleMedium = baseTypography.titleMedium.scale(scale),
            titleSmall = baseTypography.titleSmall.scale(scale),
            bodyLarge = baseTypography.bodyLarge.scale(scale),
            bodyMedium = baseTypography.bodyMedium.scale(scale),
            bodySmall = baseTypography.bodySmall.scale(scale),
            labelLarge = baseTypography.labelLarge.scale(scale),
            labelMedium = baseTypography.labelMedium.scale(scale),
            labelSmall = baseTypography.labelSmall.scale(scale)
        )
    }

    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme, // Keep existing colors
        typography = responsiveTypography,
        content = content
    )
}

// Helper extension to scale a TextStyle
private fun androidx.compose.ui.text.TextStyle.scale(factor: Float): androidx.compose.ui.text.TextStyle {
    return this.copy(
        fontSize = this.fontSize * factor,
        lineHeight = this.lineHeight * factor
    )
}