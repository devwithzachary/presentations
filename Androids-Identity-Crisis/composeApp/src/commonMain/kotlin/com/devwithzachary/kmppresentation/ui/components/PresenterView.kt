package com.devwithzachary.kmppresentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devwithzachary.kmppresentation.model.PresentationState
import com.devwithzachary.kmppresentation.ui.renderer.SlideRenderer
import kotlinx.coroutines.delay

@Composable
fun PresenterView(state: PresentationState) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {

            // TOP ROW: Controls & Timer
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Slide ${state.currentIndex + 1} / ${state.slides.size}",
                    style = MaterialTheme.typography.titleLarge
                )

                TimerView() // Custom timer component (defined below)

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { state.prev() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Prev")
                        Spacer(Modifier.width(8.dp))
                        Text("Prev")
                    }
                    Button(onClick = { state.next() }) {
                        Text("Next")
                        Spacer(Modifier.width(8.dp))
                        Icon(Icons.Default.ArrowForward, contentDescription = "Next")
                    }
                }
            }

            // MIDDLE ROW: Slides
            Row(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // LEFT: Current Slide (Takes up 70% of the width)
                Column(modifier = Modifier.weight(0.7f).fillMaxHeight()) {
                    Text("CURRENT", style = MaterialTheme.typography.labelLarge, color = Color.Gray)
                    Spacer(Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        // Magic: Reusing SlideRenderer. It will auto-scale!
                        SlideRenderer(state.currentSlide)
                    }
                }

                // RIGHT: Next Slide (Takes up 30% of the width)
                Column(modifier = Modifier.weight(0.3f).fillMaxHeight()) {
                    Text("NEXT", style = MaterialTheme.typography.labelLarge, color = Color.Gray)
                    Spacer(Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .aspectRatio(16f / 9f) // Keep it proportional
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        if (state.nextSlide != null) {
                            SlideRenderer(state.nextSlide!!)
                        } else {
                            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text("End of Presentation")
                            }
                        }
                    }

                    Spacer(Modifier.height(32.dp))

                    // Future Speaker Notes could go here!
                    Text("SPEAKER NOTES", style = MaterialTheme.typography.labelLarge, color = Color.Gray)
                    Text(
                        "No notes for this slide.",
                        modifier = Modifier.padding(top = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun TimerView() {
    var elapsedSeconds by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            elapsedSeconds++
        }
    }

    val minutes = elapsedSeconds / 60
    val seconds = elapsedSeconds % 60

    Text(
        text = "${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}",
        style = MaterialTheme.typography.displaySmall,
        color = if (minutes >= 40) Color.Red else MaterialTheme.colorScheme.onSurface // Warn at 40 mins
    )
}