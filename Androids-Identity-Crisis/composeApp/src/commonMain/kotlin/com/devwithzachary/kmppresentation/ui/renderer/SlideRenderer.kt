package com.devwithzachary.kmppresentation.ui.renderer

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.devwithzachary.kmppresentation.model.Slide
import com.devwithzachary.kmppresentation.ui.components.InteractiveDemoSlide
import com.devwithzachary.kmppresentation.ui.components.ResponsiveCodePlayground
import com.devwithzachary.kmppresentation.ui.theme.CodeTheme
import com.devwithzachary.kmppresentation.ui.theme.ResponsivePresentationTheme

@Composable
fun SlideRenderer(slide: Slide) {
    // 1. Capture the window size
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val windowWidth = maxWidth

        ResponsivePresentationTheme(windowWidth = windowWidth) {
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
                                Column(horizontalAlignment = Alignment.Start) {
                                    slide.items.forEach { item ->
                                        Text(
                                            text = "• $item",
                                            style = MaterialTheme.typography.displaySmall,
                                            modifier = Modifier.padding(bottom = 16.dp)
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
                                            style = MaterialTheme.typography.bodyLarge,
                                            lineHeight = MaterialTheme.typography.bodyLarge.fontSize * 1.5
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

                            is Slide.InteractiveDemo -> {
                                InteractiveDemoSlide()
                            }

                            is Slide.PlaygroundSlide -> ResponsiveCodePlayground()

                            is Slide.Custom -> slide.content()
                        }
                    }
                }
            }
        }
    }
}