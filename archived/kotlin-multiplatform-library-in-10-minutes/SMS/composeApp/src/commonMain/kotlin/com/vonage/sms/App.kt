package com.vonage.sms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val scope = rememberCoroutineScope()
    val text = "Hello from DevWorld!"
    
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            var smsText by remember { mutableStateOf("Loading") }
            LaunchedEffect(true) {
                scope.launch {
                    smsText = try {
                        SMS().sendSMS(text)
                    } catch (e: Exception) {
                        e.message ?: "error"
                    }
                }
            }
            Text(smsText)
        }
    }
}