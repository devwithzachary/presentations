package com.devwithzachary.kmppresentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.devwithzachary.kmppresentation.ui.renderer.highlightCode
import com.devwithzachary.kmppresentation.ui.theme.CodeTheme

@Composable
fun ResponsiveCodePlayground() {
    // 1. The State that drives both UI and Code
    var isEnabled by remember { mutableStateOf(true) }
    var clickCount by remember { mutableStateOf(0) }

    BoxWithConstraints(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Responsive Layout: Side-by-side on wide screens, stacked on narrow
        val isWide = maxWidth > 600.dp

        if (isWide) {
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                // Left: The Live UI
                Card(modifier = Modifier.weight(1f).fillMaxHeight()) {
                    LiveDemoArea(isEnabled, clickCount, { isEnabled = it }, { clickCount++ })
                }
                // Right: The Reactive Code
                Card(modifier = Modifier.weight(1f).fillMaxHeight(), colors = CardDefaults.cardColors(containerColor = CodeTheme.Background)) {
                    CodeViewArea(isEnabled, clickCount)
                }
            }
        } else {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                // Top: The Live UI
                Card(modifier = Modifier.weight(1f).fillMaxWidth()) {
                    LiveDemoArea(isEnabled, clickCount, { isEnabled = it }, { clickCount++ })
                }
                // Bottom: The Reactive Code
                Card(modifier = Modifier.weight(1f).fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = CodeTheme.Background)) {
                    CodeViewArea(isEnabled, clickCount)
                }
            }
        }
    }
}

@Composable
private fun LiveDemoArea(
    isEnabled: Boolean,
    count: Int,
    onToggle: (Boolean) -> Unit,
    onAdd: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.Default.TouchApp, null, modifier = Modifier.size(48.dp), tint = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(24.dp))

        Text("Interactive Component", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(32.dp))

        // The Controls
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = isEnabled, onCheckedChange = onToggle)
            Spacer(modifier = Modifier.width(8.dp))
            Text(if (isEnabled) "Enabled" else "Disabled")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onAdd,
            enabled = isEnabled,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Click Me ($count)")
        }
    }
}

@Composable
private fun CodeViewArea(isEnabled: Boolean, count: Int) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(Icons.Default.Code, null, tint = CodeTheme.Text)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Reactive Source Code", color = CodeTheme.Text, style = MaterialTheme.typography.labelLarge)
        }

        Divider(color = CodeTheme.Comment)

        Box(modifier = Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(top = 16.dp)) {
            // We construct the string dynamically based on state!
            val dynamicCode = """
                @Composable
                fun MyButton() {
                    // State flows here automatically!
                    val isEnabled = $isEnabled
                    val count = $count
                
                    Column {
                        Switch(
                            checked = isEnabled,
                            onCheckedChange = { ... }
                        )
                
                        Button(
                            onClick = { count++ },
                            enabled = isEnabled // ${if (!isEnabled) "<-- Disabled!" else ""}
                        ) {
                            Text("Click Me ($count)")
                        }
                    }
                }
            """.trimIndent()

            Text(
                text = highlightCode(dynamicCode),
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = MaterialTheme.typography.bodyMedium.fontSize * 1.4
            )
        }
    }
}