package com.devwithzachary.kmppresentation.ui.renderer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.devwithzachary.kmppresentation.model.Slide
import com.devwithzachary.kmppresentation.ui.components.InteractiveDemoSlide
import com.devwithzachary.kmppresentation.ui.components.PrizeWheel
import com.devwithzachary.kmppresentation.ui.components.ResponsiveCodePlayground
import com.devwithzachary.kmppresentation.ui.theme.CodeTheme
import com.devwithzachary.kmppresentation.ui.theme.ResponsivePresentationTheme
import kmppresentation.composeapp.generated.resources.Res

@Composable
fun SlideRenderer(slide: Slide) {
    // 1. Capture the window size
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val windowWidth = maxWidth
        val windowHeight = maxHeight

        ResponsivePresentationTheme(windowWidth = windowWidth,
            windowHeight = windowHeight) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier.padding(32.dp).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = slide.title,
                        style = MaterialTheme.typography.displayMedium, // Now huge!
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        when (slide) {
                            is Slide.Title -> {
                                Text(
                                    text = slide.subtitle,
                                    style = MaterialTheme.typography.headlineLarge,
                                    textAlign = TextAlign.Center
                                )
                            }

                            is Slide.BulletList -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 32.dp),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.Top
                                ) {
                                    slide.items.forEach { item ->
                                        Text(
                                            text = "• $item",
                                            style = MaterialTheme.typography.displaySmall,
                                            modifier = Modifier.padding(bottom = 24.dp)
                                        )
                                    }
                                }
                            }

                            is Slide.Code -> {
                                Card(
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .background(CodeTheme.Background)
                                            .fillMaxWidth()
                                            .horizontalScroll(rememberScrollState())
                                            .padding(24.dp)
                                    ) {
                                        Text(
                                            text = highlightCode(slide.codeSnippet),
                                            fontFamily = FontFamily.Monospace,
                                            style = MaterialTheme.typography.bodyMedium,
                                            lineHeight = MaterialTheme.typography.bodyMedium.fontSize * 1.5
                                        )
                                    }
                                }
                            }

                            is Slide.ImageSlide -> {
                                Column(
                                    modifier = Modifier.fillMaxSize(), // Fill the space provided by the slide renderer
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center // Center the whole group vertically
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(slide.image),
                                            contentDescription = slide.caption ?: slide.title,
                                            modifier = Modifier.fillMaxSize(), // Fill the weighed Box
                                            contentScale = androidx.compose.ui.layout.ContentScale.Fit
                                        )
                                    }

                                    if (slide.caption != null) {
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Text(
                                            text = slide.caption,
                                            style = MaterialTheme.typography.headlineSmall,
                                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }

                            is Slide.TextAndImage -> {
                                BoxWithConstraints {
                                    val isWide = maxWidth > 600.dp // Switch to stack on phone

                                    // Define content for reusability
                                    val textContent = @Composable {
                                        Column(
                                            // Change Center -> Top here
                                            verticalArrangement = Arrangement.Top,
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(top = 32.dp)
                                        ) {
                                            slide.bullets.forEach { item ->
                                                Text(
                                                    text = "• $item",
                                                    style = MaterialTheme.typography.headlineSmall,
                                                    modifier = Modifier.padding(bottom = 24.dp)
                                                )
                                            }
                                        }
                                    }

                                    val imageContent = @Composable {
                                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                            Image(
                                                painter = painterResource(slide.image),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .fillMaxHeight(0.8f) // Don't touch edges vertically
                                                    .clip(RoundedCornerShape(16.dp)), // Nice rounded corners
                                                contentScale = androidx.compose.ui.layout.ContentScale.Fit
                                            )
                                        }
                                    }

                                    if (isWide) {
                                        // DESKTOP: 50/50 Split
                                        Row(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            // Left: Text
                                            Box(modifier = Modifier.weight(1f).padding(end = 32.dp)) {
                                                textContent()
                                            }
                                            // Right: Image
                                            Box(modifier = Modifier.weight(1f)) {
                                                imageContent()
                                            }
                                        }
                                    } else {
                                        // MOBILE: Stack Vertical
                                        Column(modifier = Modifier.fillMaxSize()) {
                                            Box(modifier = Modifier.weight(1f)) { imageContent() }
                                            Box(modifier = Modifier.weight(1f)) { textContent() }
                                        }
                                    }
                                }
                            }

                            is Slide.InteractiveDemo -> {
                                InteractiveDemoSlide()
                            }

                            is Slide.PlaygroundSlide -> ResponsiveCodePlayground()

                            is Slide.PrizeDraw -> {
                                var winner by remember { mutableStateOf<String?>(null) }
                                var participants by remember { mutableStateOf<List<String>>(emptyList()) }
                                var isLoading by remember { mutableStateOf(true) }
                                var error by remember { mutableStateOf<String?>(null) }

                                LaunchedEffect(slide.fileName) {
                                    try {
                                        // Read file from 'composeResources/files/'
                                        // Note: Use the path relative to the 'files' directory if using the latest KMP wizard
                                        val bytes = Res.readBytes("files/${slide.fileName}")
                                        val content = bytes.decodeToString()
                                        participants = parseRaffleCsv(content)
                                        isLoading = false
                                    } catch (e: Exception) {
                                        e.printStackTrace()
                                        error = "Could not load ${slide.fileName}: ${e.message}"
                                        isLoading = false
                                    }
                                }

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    if (isLoading) {
                                        CircularProgressIndicator()
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Text("Loading participants...", style = MaterialTheme.typography.bodyLarge)
                                    } else if (error != null) {
                                        Text("Error: $error", color = MaterialTheme.colorScheme.error)
                                    } else if (participants.isEmpty()) {
                                        Text("No participants found in ${slide.fileName}", style = MaterialTheme.typography.headlineSmall)
                                    } else {
                                        Box(modifier = Modifier.weight(1f).padding(32.dp)) {
                                            PrizeWheel(
                                                names = participants,
                                                onWinnerSelected = { winner = it }
                                            )
                                        }

                                        // Winner Announcement
                                        AnimatedVisibility(visible = winner != null) {
                                            Text(
                                                text = "🎉 The Winner is: $winner! 🎉",
                                                style = MaterialTheme.typography.displaySmall,
                                                color = MaterialTheme.colorScheme.primary,
                                                modifier = Modifier.padding(bottom = 32.dp)
                                            )
                                        }
                                    }
                                }
                            }

                            is Slide.Custom -> slide.content()
                        }
                    }
                }
            }
        }
    }
}