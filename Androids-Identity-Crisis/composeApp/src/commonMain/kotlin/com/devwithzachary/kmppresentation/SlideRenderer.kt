package com.devwithzachary.kmppresentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
                    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                        Text(
                            text = slide.codeSnippet,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                is Slide.Custom -> slide.content()
            }
        }
    }
}