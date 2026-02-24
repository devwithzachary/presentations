package com.devwithzachary.kmppresentation.ui.renderer

fun parseRaffleCsv(content: String): List<String> {
    return content.lines()
        .drop(1) // Drop the "TEST" header
        .filter { it.isNotBlank() } // Skip empty lines
        .map { line ->
            // Robust cleanup:
            // 1. Trim whitespace
            // 2. Remove all quotes (handles "Name" and """Name""")
            line.trim().replace("\"", "")
        }
        .filter { it.isNotEmpty() }
}