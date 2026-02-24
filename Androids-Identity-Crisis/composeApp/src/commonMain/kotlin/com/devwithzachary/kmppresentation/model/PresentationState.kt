package com.devwithzachary.kmppresentation.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PresentationState(val slides: List<Slide>) {
    var currentIndex by mutableStateOf(0)
        private set

    val currentSlide: Slide
        get() = slides[currentIndex]

    val nextSlide: Slide?
        get() = if (currentIndex < slides.size - 1) slides[currentIndex + 1] else null

    fun next() {
        if (currentIndex < slides.size - 1) {
            currentIndex++
        }
    }

    fun prev() {
        if (currentIndex > 0) {
            currentIndex--
        }
    }
}