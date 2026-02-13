package com.devwithzachary.kmppresentation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight

fun highlightCode(code: String): AnnotatedString {
    return buildAnnotatedString {
        // 1. Default Style (Base Text)
        append(code)
        addStyle(
            style = SpanStyle(color = CodeTheme.Text),
            start = 0,
            end = code.length
        )

        // 2. Define Regex Patterns
        val keywords = Regex("\\b(fun|val|var|class|interface|object|return|if|else|when|for|while|package|import|true|false|null|override|private|public|protected|internal|data|sealed|companion)\\b")
        val annotations = Regex("@\\w+")
        val numbers = Regex("\\b\\d+\\b")
        val strings = Regex("\"[^\"]*\"")
        val comments = Regex("//.*") // Single line comments

        // Helper to apply style
        fun apply(regex: Regex, style: SpanStyle) {
            regex.findAll(code).forEach { result ->
                addStyle(style, result.range.first, result.range.last + 1)
            }
        }

        // 3. Apply Styles (Order matters! Comments last so they override everything inside them)
        apply(keywords, SpanStyle(color = CodeTheme.Keyword, fontWeight = FontWeight.Bold))
        apply(annotations, SpanStyle(color = CodeTheme.Annotation))
        apply(numbers, SpanStyle(color = CodeTheme.Number))
        apply(strings, SpanStyle(color = CodeTheme.String))
        apply(comments, SpanStyle(color = CodeTheme.Comment)) // Comments win
    }
}