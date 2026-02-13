package com.devwithzachary.kmppresentation.ui.components

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class DeviceType(val label: String, val width: Dp, val height: Dp, val cornerRadius: Dp) {
    Phone("Phone", 360.dp, 640.dp, 32.dp),
    Tablet("Tablet", 800.dp, 600.dp, 16.dp), // Landscape
    Watch("Watch", 200.dp, 200.dp, 100.dp), // Circular-ish
    Auto("Auto", 600.dp, 300.dp, 8.dp),     // Wide, short
    Desktop("Desktop", 900.dp, 500.dp, 4.dp)
}