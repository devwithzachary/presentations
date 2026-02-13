package com.devwithzachary.kmppresentation

import kmppresentation.composeapp.generated.resources.Res
import kmppresentation.composeapp.generated.resources.android_logo

val myPresentationSlides = listOf(
    Slide.Title(
        title = "Android's Identity Crisis",
        subtitle = "From Phone OS to Ubiquitous Platform\n(Built with KMP)"
    ),
    Slide.BulletList(
        title = "The Shift",
        items = listOf(
            "2010: It's a phone OS.",
            "2020: It's on cars, watches, TVs.",
            "2026: The OS is an implementation detail.",
            "We are no longer 'Android Developers', we are 'Kotlin UI Developers'."
        )
    ),
    Slide.Code(
        title = "The New Standard",
        codeSnippet = """
            @Composable
            fun App() {
               // Runs on Android, iOS, Desktop, Web
               Text("Hello Universal UI")
            }
        """.trimIndent()
    ),
    Slide.ImageSlide(
            title = "The Evolution",
    image = Res.drawable.android_logo, // This matches your filename
    caption = "From a green robot to a multi-platform powerhouse."
)
)