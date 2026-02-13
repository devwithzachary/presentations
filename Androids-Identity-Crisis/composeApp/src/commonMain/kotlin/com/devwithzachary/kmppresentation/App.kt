package com.devwithzachary.kmppresentation

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.*
import kotlinx.coroutines.launch
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue

@Composable
fun App() {

    val transitionSpec = tween<Float>(
        durationMillis = 600,
        easing = FastOutSlowInEasing
    )

    MaterialTheme {
        val pagerState = rememberPagerState(pageCount = { myPresentationSlides.size })
        val scope = rememberCoroutineScope()
        val focusRequester = remember { FocusRequester() }

        // Navigation Logic
        fun goToNext() {
            if (pagerState.currentPage < myPresentationSlides.lastIndex) {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage + 1,
                        animationSpec = transitionSpec
                    )
                }
            }
        }

        fun goToPrev() {
            if (pagerState.currentPage < myPresentationSlides.lastIndex) {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage - 1,
                        animationSpec = transitionSpec
                    )
                }
            }
        }

        // The Root Box captures the key events
        Box(
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(focusRequester)
                .focusable()
                .onKeyEvent { event ->
                    if (event.type == KeyEventType.KeyDown) {
                        when (event.key) {
                            // Standard Clicker / Keyboard Mappings
                            Key.PageDown, Key.DirectionRight, Key.Spacebar -> {
                                goToNext()
                                true
                            }
                            Key.PageUp, Key.DirectionLeft -> {
                                goToPrev()
                                true
                            }
                            else -> false
                        }
                    } else {
                        false
                    }
                }
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = false // Keep false for clicker-only control
            ) { pageIndex ->

                val pageOffset = (
                        (pagerState.currentPage - pageIndex) + pagerState.currentPageOffsetFraction
                        ).absoluteValue

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            val scale = lerp(
                                start = 1f,
                                stop = 0.85f,
                                fraction = pageOffset.coerceIn(0f, 1f)
                            )
                            scaleX = scale
                            scaleY = scale

                            alpha = lerp(
                                start = 1f,
                                stop = 0.5f,
                                fraction = pageOffset.coerceIn(0f, 1f)
                            )

                        }
                ) {
                    SlideRenderer(myPresentationSlides[pageIndex])
                }
            }
        }

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}