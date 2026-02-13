package com.devwithzachary.kmppresentation

import androidx.compose.runtime.Composable

sealed interface Slide {
    val title: String

    data class Title(
        override val title: String,
        val subtitle: String
    ) : Slide

    data class BulletList(
        override val title: String,
        val items: List<String>
    ) : Slide

    data class Code(
        override val title: String,
        val codeSnippet: String
    ) : Slide

    // A special slide that takes a Composable for total freedom
    data class Custom(
        override val title: String,
        val content: @Composable () -> Unit
    ) : Slide
}