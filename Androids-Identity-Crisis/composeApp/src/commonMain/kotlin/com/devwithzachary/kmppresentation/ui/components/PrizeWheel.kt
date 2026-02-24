package com.devwithzachary.kmppresentation.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutCirc
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun PrizeWheel(
    names: List<String>,
    onWinnerSelected: (String) -> Unit
) {
    // Physics State
    val rotation = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    var isSpinning by remember { mutableStateOf(false) }

    // Colors
    val colors = listOf(
        Color(0xFFEF5350), Color(0xFFAB47BC), Color(0xFF42A5F5),
        Color(0xFF26A69A), Color(0xFFFFEE58), Color(0xFFFF7043)
    )

    val textMeasurer = rememberTextMeasurer()
    val textStyle = MaterialTheme.typography.labelLarge.copy(color = Color.White)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Square container
            .pointerInput(Unit) {
                detectTapGestures {
                    if (!isSpinning) {
                        isSpinning = true
                        scope.launch {
                            // Spin Calculation
                            // 1. Random spin amount (5 to 10 full rotations)
                            val spinAngle = (360f * 5) + (Random.nextFloat() * 360f * 5)
                            val targetRotation = rotation.value + spinAngle

                            rotation.animateTo(
                                targetValue = targetRotation,
                                animationSpec = tween(durationMillis = 4000, easing = EaseOutCirc)
                            )

                            // Calculate Winner
                            // The pointer is at 270 degrees (Top)
                            val normalizedAngle = targetRotation % 360f
                            val segmentArc = 360f / names.size
                            // Math to find which segment is at the top
                            val pointerAngle = (270f - normalizedAngle + 360f) % 360f
                            val index = (pointerAngle / segmentArc).toInt() % names.size

                            onWinnerSelected(names[index])
                            isSpinning = false
                        }
                    }
                }
            }
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // 1. Calculate safe radius
            // We take the smaller side (width or height) and divide by 2.
            // Then we multiply by 0.85f to leave 15% padding for the pointer.
            val radius = (size.minDimension / 2) * 0.85f

            val center = center // The exact center of the canvas area

            // 2. Draw Wheel
            rotate(degrees = rotation.value, pivot = center) {
                val segmentAngle = 360f / names.size

                names.forEachIndexed { index, name ->
                    // A. Draw Segment
                    drawArc(
                        color = colors[index % colors.size],
                        startAngle = index * segmentAngle,
                        sweepAngle = segmentAngle,
                        useCenter = true,
                        topLeft = Offset(center.x - radius, center.y - radius),
                        size = Size(radius * 2, radius * 2)
                    )

                    // B. Draw Text
                    // Rotate canvas to center of segment
                    val textAngle = (index * segmentAngle) + (segmentAngle / 2)

                    rotate(degrees = textAngle, pivot = center) {
                        val textLayout = textMeasurer.measure(
                            text = name,
                            style = textStyle,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )

                        // Draw text at 70% from center
                        drawText(
                            textLayoutResult = textLayout,
                            topLeft = Offset(
                                center.x + (radius * 0.7f),
                                center.y - (textLayout.size.height / 2)
                            )
                        )
                    }
                }
            }

            // 3. Draw Static Pointer (Arrow)
            // The pointer sits at the top (12 o'clock)
            val pointerWidth = 40f
            val pointerHeight = 50f

            // Calculate the tip of the arrow (pointing slightly into the wheel)
            val tipY = center.y - radius + 20f

            val path = Path().apply {
                moveTo(center.x, tipY) // Tip
                lineTo(center.x - (pointerWidth / 2), tipY - pointerHeight) // Top Left
                lineTo(center.x + (pointerWidth / 2), tipY - pointerHeight) // Top Right
                close()
            }

            // Draw Shadow
            drawPath(path, Color.Black.copy(alpha = 0.3f))
            // Draw Arrow Body
            drawPath(path, Color.Red)

            // Draw Center Pin
            drawCircle(Color.White, radius = 15f, center = center)
        }
    }
}