package com.devwithzachary.kmppresentation

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource

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

    data class ImageSlide(
        override val title: String,
        val image: DrawableResource, // <--- The magic type
        val caption: String? = null
    ) : Slide

    data object InteractiveDemo : Slide {
        override val title: String = "Ubiquitous Computing"
    }
    // A special slide that takes a Composable for total freedom
    data class Custom(
        override val title: String,
        val content: @Composable () -> Unit
    ) : Slide
}