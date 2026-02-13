package com.devwithzachary.kmppresentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.focusable
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme {
        val pagerState = rememberPagerState(pageCount = { myPresentationSlides.size })
        val scope = rememberCoroutineScope()

        // Keyboard handling for Desktop
        val focusRequester = remember { FocusRequester() }

        val onNext = {
            if (pagerState.currentPage < myPresentationSlides.lastIndex) {
                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
            }
        }
        val onPrev = {
            if (pagerState.currentPage > 0) {
                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(focusRequester)
                .focusable()
                .onKeyEvent { event ->
                    if (event.type == KeyEventType.KeyDown) {
                        when (event.key) {
                            Key.DirectionRight, Key.Spacebar -> { onNext(); true }
                            Key.DirectionLeft -> { onPrev(); true }
                            else -> false
                        }
                    } else false
                }
        ) { pageIndex ->
            SlideRenderer(myPresentationSlides[pageIndex])
        }

        // Request focus so keyboard events are captured immediately
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}