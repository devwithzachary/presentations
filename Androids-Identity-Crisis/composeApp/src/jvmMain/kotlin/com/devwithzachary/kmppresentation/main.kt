package com.devwithzachary.kmppresentation

import androidx.compose.runtime.remember
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.devwithzachary.kmppresentation.model.PresentationState
import com.devwithzachary.kmppresentation.model.myPresentationSlides
import com.devwithzachary.kmppresentation.ui.components.PresenterView
import com.devwithzachary.kmppresentation.ui.renderer.SlideRenderer
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.key.Key

fun main() = application {
    // 1. Create the Shared State
    val state = remember { PresentationState(myPresentationSlides) }

    // 2. The Keyboard Event Handler (Shared)
    // This allows you to use your clicker/keyboard no matter which window has focus!
    val keyEventHandler: (androidx.compose.ui.input.key.KeyEvent) -> Boolean = { event ->
        if (event.type == KeyEventType.KeyUp) {
            when (event.key) {
                Key.DirectionRight, Key.Spacebar, Key.Enter, Key.PageDown -> {
                    state.next()
                    true
                }
                Key.DirectionLeft, Key.Backspace, Key.PageUp -> {
                    state.prev()
                    true
                }
                else -> false
            }
        } else false
    }

    // 3. MAIN PRESENTATION WINDOW (To put on the projector)
    Window(
        onCloseRequest = ::exitApplication,
        title = "Presentation (Projector)",
        state = rememberWindowState(position = WindowPosition(Alignment.Center)),
        onKeyEvent = keyEventHandler
    ) {
        // Just render the current slide directly
        SlideRenderer(state.currentSlide)
    }

    // 4. PRESENTER WINDOW (To keep on your laptop screen)
    Window(
        onCloseRequest = ::exitApplication,
        title = "Presenter View (Laptop)",
        onKeyEvent = keyEventHandler
    ) {
        PresenterView(state = state)
    }
}