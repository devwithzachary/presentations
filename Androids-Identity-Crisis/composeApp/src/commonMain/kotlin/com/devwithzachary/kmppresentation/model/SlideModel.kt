package com.devwithzachary.kmppresentation.model

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
        val image: DrawableResource,
        val caption: String? = null
    ) : Slide

    data object InteractiveDemo : Slide {
        override val title: String = "Ubiquitous Computing"
    }

    data object PlaygroundSlide : Slide {
        override val title = "State & UI: One Source"
    }
    // A special slide that takes a Composable for total freedom
    data class Custom(
        override val title: String,
        val content: @Composable () -> Unit
    ) : Slide
}