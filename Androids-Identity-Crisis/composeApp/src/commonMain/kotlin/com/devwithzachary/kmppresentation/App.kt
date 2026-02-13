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

@Composable
fun App() {
    MaterialTheme {
        val pagerState = rememberPagerState(pageCount = { myPresentationSlides.size })
        val scope = rememberCoroutineScope()
        val focusRequester = remember { FocusRequester() }

        // Navigation Logic
        fun goToNext() {
            if (pagerState.currentPage < myPresentationSlides.lastIndex) {
                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
            }
        }

        fun goToPrev() {
            if (pagerState.currentPage > 0) {
                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) }
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
                userScrollEnabled = false // Optional: Disable swipe if you want strict clicker control
            ) { pageIndex ->
                SlideRenderer(myPresentationSlides[pageIndex])
            }
        }

        // Crucial: Request focus immediately so the app catches the first click
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}