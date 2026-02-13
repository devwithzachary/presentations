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
import com.devwithzachary.kmppresentation.model.Slide
import com.devwithzachary.kmppresentation.ui.components.InteractiveDemoSlide
import com.devwithzachary.kmppresentation.ui.theme.CodeTheme

@Composable
fun SlideRenderer(slide: Slide) {
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
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(32.dp))

            when (slide) {
                is Slide.Title -> {
                    Text(
                        text = slide.subtitle,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                is Slide.BulletList -> {
                    Column(horizontalAlignment = Alignment.Start) {
                        slide.items.forEach { item ->
                            Text(
                                text = "• $item",
                                style = MaterialTheme.typography.bodyLarge,
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
                        // Ensure card handles clicks so keys don't get trapped (optional, based on previous fix)
                    ) {
                        Box(
                            modifier = Modifier
                                .background(CodeTheme.Background) // Dark background
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()) // Allow horizontal scrolling for long lines
                                .padding(24.dp)
                        ) {
                            Text(
                                text = highlightCode(slide.codeSnippet), // <--- THE MAGIC
                                fontFamily = FontFamily.Monospace,
                                style = MaterialTheme.typography.bodyLarge,
                                lineHeight = MaterialTheme.typography.bodyLarge.fontSize * 1.5 // Breathing room
                            )
                        }
                    }
                }

                is Slide.ImageSlide -> {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().weight(1f)) {
                        Image(
                            painter = painterResource(slide.image),
                            contentDescription = slide.caption ?: slide.title,
                            modifier = Modifier
                                .fillMaxHeight(0.8f) // Don't let it take over the title
                                .fillMaxWidth(),
                            contentScale = androidx.compose.ui.layout.ContentScale.Fit
                        )
                    }

                    if (slide.caption != null) {
                        Text(
                            text = slide.caption,
                            style = MaterialTheme.typography.labelLarge,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                is Slide.InteractiveDemo -> {
                    InteractiveDemoSlide()
                }

                is Slide.Custom -> slide.content()
            }
        }
    }
}