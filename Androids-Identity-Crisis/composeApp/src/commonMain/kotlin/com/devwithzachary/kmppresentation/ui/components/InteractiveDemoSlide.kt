package com.devwithzachary.kmppresentation.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InteractiveDemoSlide() {
    var selectedDevice by remember { mutableStateOf(DeviceType.Phone) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. The Selector Bar
        Row(
            modifier = Modifier.padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DeviceType.entries.forEach { device ->
                FilterChip(
                    selected = selectedDevice == device,
                    onClick = { selectedDevice = device },
                    label = { Text(device.label) },
                    leadingIcon = {
                        Icon(
                            imageVector = when(device) {
                                DeviceType.Phone -> Icons.Default.Smartphone
                                DeviceType.Tablet -> Icons.Default.Tablet
                                DeviceType.Watch -> Icons.Default.Watch
                                DeviceType.Auto -> Icons.Default.DirectionsCar
                                DeviceType.Desktop -> Icons.Default.Computer
                            },
                            contentDescription = null
                        )
                    }
                )
            }
        }

        // 2. The "Simulator" Container
        // We animate width, height, and corner radius
        val animWidth by animateDpAsState(selectedDevice.width, spring(stiffness = Spring.StiffnessLow))
        val animHeight by animateDpAsState(selectedDevice.height, spring(stiffness = Spring.StiffnessLow))
        val animCorner by animateDpAsState(selectedDevice.cornerRadius)

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(animWidth, animHeight)
                .shadow(16.dp, RoundedCornerShape(animCorner))
                .clip(RoundedCornerShape(animCorner))
                .background(Color.White)
                .border(4.dp, Color(0xFF333333), RoundedCornerShape(animCorner))
        ) {
            // 3. The Responsive UI content
            // We pass the *current* device type down so the UI knows how to render
            ResponsiveMockApp(selectedDevice)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResponsiveMockApp(device: DeviceType) {
    // Common Data
    val items = List(10) { "Item ${it + 1}" }

    MaterialTheme { // Nested theme for the "app"
        Scaffold(
            topBar = {
                if (device != DeviceType.Watch) { // No TopBar on Watch
                    OptIn(ExperimentalMaterial3Api::class)
                    TopAppBar(
                        title = { Text("My KMP App") },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                    )
                }
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding).fillMaxSize()) {
                when (device) {
                    DeviceType.Watch -> {
                        // Watch: Minimal List, big text
                        LazyColumn(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            item { Text("Now Playing", style = MaterialTheme.typography.labelSmall) }
                            item {
                                Icon(Icons.Default.PlayCircle, null, modifier = Modifier.size(48.dp))
                            }
                        }
                    }
                    DeviceType.Tablet, DeviceType.Desktop, DeviceType.Auto -> {
                        // Large Screen: Grid
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(120.dp),
                            contentPadding = PaddingValues(16.dp)
                        ) {
                            items(items.size) {
                                Card(modifier = Modifier.padding(8.dp).height(100.dp)) {
                                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                        Text("Grid Item")
                                    }
                                }
                            }
                        }
                    }
                    DeviceType.Phone -> {
                        // Phone: Standard List
                        LazyColumn(contentPadding = PaddingValues(16.dp)) {
                            items(items.size) {
                                ListItem(
                                    headlineContent = { Text("List Item $it") },
                                    leadingContent = { Icon(Icons.Default.Person, null) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}