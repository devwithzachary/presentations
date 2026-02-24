package com.devwithzachary.kmppresentation.model

import kmppresentation.composeapp.generated.resources.Res
import kmppresentation.composeapp.generated.resources.Samsung_Galaxy_S_White
import kmppresentation.composeapp.generated.resources.android_devices
import kmppresentation.composeapp.generated.resources.find_me
import kmppresentation.composeapp.generated.resources.found_me
import kmppresentation.composeapp.generated.resources.github_qr
import kmppresentation.composeapp.generated.resources.htc_evo_4g_android_phone_cdma_4g_4_3_white_sprint_nextel
import kmppresentation.composeapp.generated.resources.kotlinmultiplatform
import kmppresentation.composeapp.generated.resources.me_droidcon_2023
import kmppresentation.composeapp.generated.resources.me_droidcon_2025
import kmppresentation.composeapp.generated.resources.motorola_droid_2_1
import kmppresentation.composeapp.generated.resources.motorola_moto_360_2015_1
import kmppresentation.composeapp.generated.resources.motorola_xoom_1
import kmppresentation.composeapp.generated.resources.qr_code
import kmppresentation.composeapp.generated.resources.young_me

val myPresentationSlides = listOf(
    /*Slide.PrizeDraw(
        title = "Giveaway Time!",
        fileName = "raffle.csv"
    ),*/
    Slide.Title(
        title = "Beyond the Smartphone",
        subtitle = "Android’s Identity Crisis in 2026"
    ),
    Slide.TextAndImage(
        title = "About Me",
        bullets = listOf(
            "Android Dev Since 2009 (I think this is XDA DevCon 2014?!)"
        ),
        image = Res.drawable.young_me
    ),
    Slide.TextAndImage(
        title = "About Me",
        bullets = listOf(
            "Android Dev Since 2009 (I think this is XDA DevCon 2014?!)",
            "Android Developer Advocate at Vonage"
        ),
        image = Res.drawable.me_droidcon_2023
    ),
    Slide.TextAndImage(
        title = "About Me",
        bullets = listOf(
            "Android Dev Since 2009 (I think this is XDA DevCon 2014?!)",
            "Android Developer Advocate at Vonage",
            "Head of Developer Community @ Mobile Seasons"
        ),
        image = Res.drawable.me_droidcon_2023
    ),
    Slide.TextAndImage(
        title = "About Me",
        bullets = listOf(
            "Android Dev Since 2009 (I think this is XDA DevCon 2014?!)",
            "Android Developer Advocate at Vonage",
            "Head of Developer Community @ Mobile Seasons",
            "Head of Developer Community @ The Company That Runs droidCon"
        ),
        image = Res.drawable.me_droidcon_2025,
    ),
    Slide.TextAndImage(
        title = "About Me",
        bullets = listOf(
            "Android Dev Since 2009 (I think this is XDA DevCon 2014?!)",
            "Android Developer Advocate at Vonage",
            "Head of Developer Community @ Mobile Seasons",
            "Head of Developer Community @ The Company That Runs droidCon"
        ),
        image = Res.drawable.find_me,
    ),
    Slide.TextAndImage(
        title = "About Me",
        bullets = listOf(
            "Android Dev Since 2009 (I think this is XDA DevCon 2014?!)",
            "Android Developer Advocate at Vonage",
            "Head of Developer Community @ Mobile Seasons",
            "Head of Developer Community @ The Company That Runs droidCon"
        ),
        image = Res.drawable.found_me,
    ),
    Slide.TextAndImage(
        title = "Free Stuff!",
        bullets = listOf(
            "3x 100% off Voucher Codes for Android Makers by droidCon",
            "3x 100% off Voucher Codes for droidCon London 2026",
            "5x 100% off Voucher Codes for Next App devCon",
        ),
        image = Res.drawable.qr_code,
    ),
    Slide.ImageSlide(
        title = "Android in the Early Days",
        image = Res.drawable.Samsung_Galaxy_S_White,
        caption = "Samsung Galaxy S"
    ),
    Slide.ImageSlide(
        title = "Android in the Early Days",
        image = Res.drawable.htc_evo_4g_android_phone_cdma_4g_4_3_white_sprint_nextel,
        caption = "HTC EVO 4G"
    ),
    Slide.ImageSlide(
        title = "Android in the Early Days",
        image = Res.drawable.motorola_droid_2_1,
        caption = "Motorola Droid 2 (Milestone 2)"
    ),
    Slide.ImageSlide(
        title = "Android in the Early Days",
        image = Res.drawable.motorola_xoom_1,
        caption = "Motorola Xoom"
    ),
    Slide.ImageSlide(
        title = "Android in the Early Days",
        image = Res.drawable.motorola_moto_360_2015_1,
        caption = "Motorola Moto 360"
    ),
    Slide.ImageSlide(
        title = "Fast Forward to 2026",
        image = Res.drawable.android_devices,
        caption = "Android on ALL THE THINGS"
    ),
    Slide.ImageSlide(
        title = "Fast Forward to 2026",
        image = Res.drawable.kotlinmultiplatform,
        caption = "Kotlin on ALL THE THINGS"
    ),
    Slide.InteractiveDemo,
    Slide.ImageSlide(
        title = "Who is still just designing, building and testing for this?",
        image = Res.drawable.Samsung_Galaxy_S_White,
        caption = "Samsung Galaxy S"
    ),
    Slide.TextAndImage(
        title = "We Need To Design, Build and Test For This",
        bullets = listOf(
            "Targeting just a phone is missing out on large markets"
        ),
        image = Res.drawable.android_devices,
    ),
    Slide.TextAndImage(
        title = "We Need To Design, Build and Test For This",
        bullets = listOf(
            "Targeting just a phone is missing out on large markets",
            "Wide range of inputs, gone are the days of onClick being enough"
        ),
        image = Res.drawable.android_devices,
    ),
    Slide.TextAndImage(
        title = "We Need To Design, Build and Test For This",
        bullets = listOf(
            "Targeting just a phone is missing out on large markets",
            "Wide range of inputs, gone are the days of onClick being enough",
            "Screen sizes can be widely different"
        ),
        image = Res.drawable.android_devices,
    ),
    Slide.TextAndImage(
        title = "We Need To Design, Build and Test For This",
        bullets = listOf(
            "Targeting just a phone is missing out on large markets",
            "Wide range of inputs, gone are the days of onClick being enough",
            "Screen sizes can be widely different",
            "OR change while the app is running! adaptive layouts are a must"
        ),
        image = Res.drawable.android_devices,
    ),
    Slide.Title(
        title = "Beyond the Smartphone",
        subtitle = " We don't build Screens anymore, we build UI States that flow into whatever container they are poured into"
    ),

    Slide.BulletList(
        title = "What you should all be doing today!",
        items = listOf(
            "Don't build for the phone you have; build for the canvas you'll get.",
        )
    ),
    Slide.BulletList(
        title = "What you should all be doing today!",
        items = listOf(
            "Don't build for the phone you have; build for the canvas you'll get.",
            "Embrace the Canonical Layouts: Stop \"hand-rolling\" responsive design"
        )
    ),
    Slide.BulletList(
        title = "What you should all be doing today!",
        items = listOf(
            "Don't build for the phone you have; build for the canvas you'll get.",
            "Embrace the Canonical Layouts: Stop \"hand-rolling\" responsive design",
            "Use the Window Size Classes and Canonical Layouts provided by Google."
        )
    ),
    Slide.Code(
        title = "Hand-Rolled Logic",
        codeSnippet = """
            @Composable
            fun ManualResponsiveLayout(items: List<Item>) {
                val configuration = LocalConfiguration.current
                // Hardcoded Magic Numbers that doesnt take into account multi-window or foldables
                val isTablet = configuration.screenWidthDp > 600 
                if (isTablet) {
                    Row(Modifier.fillMaxSize()) {
                        ItemList(items, Modifier.weight(1f))
                        ItemDetail(Modifier.weight(2f))
                    }
                } else {
                    // You have to manually handle navigation back/forth between these
                    ItemList(items, Modifier.fillMaxSize())
                }
            }
        """.trimIndent()
    ),
    Slide.Code(
        title = "Windows Size Classes and Scaffolds",
        codeSnippet = """
            @Composable
            fun ModernAdaptiveLayout(items: List<Item>) {
                // 1. Calculate the Window Size Class (Compact, Medium, or Expanded)
                val windowSizeClass = calculateWindowSizeClass()
                // 2. Use a Navigator to manage the state of which "pane" is active
                val navigator = rememberListDetailPaneScaffoldNavigator<Item>()
                // 3. Use the Canonical Layout: ListDetailPaneScaffold
                ListDetailPaneScaffold(
                    directive = calculatePaneScaffoldDirective(windowSizeClass),
                    value = navigator.scaffoldValue,
                    listPane = {
                        AnimatedPane {
                            ItemList(items = items, onItemClick = { 
                                item -> navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, item)})
                        }
                    },
                    detailPane = {
                        AnimatedPane {
                            val selectedItem = navigator.currentDestination?.content
                            if (selectedItem != null) { ItemDetail(item = selectedItem)
                            } else { EmptyDetailPlaceholder() }
                        }
                    }
                )
            }
        """.trimIndent()
    ),
    Slide.BulletList(
        title = "Key Changes in SDK 37 (Android 17)",
        items = listOf(
            "When running on a large screen (smaller dimension ≥ 600dp), the following attributes and APIs will be ignored",
            "screenOrientation - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
        )
    ),
    Slide.BulletList(
        title = "Key Changes in SDK 37 (Android 17)",
        items = listOf(
            "When running on a large screen (smaller dimension ≥ 600dp), the following attributes and APIs will be ignored",
            "screenOrientation - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
            "setRequestedOrientation() - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape"
        )
    ),
    Slide.BulletList(
        title = "Key Changes in SDK 37 (Android 17)",
        items = listOf(
            "When running on a large screen (smaller dimension ≥ 600dp), the following attributes and APIs will be ignored",
            "screenOrientation - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
            "setRequestedOrientation() - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
            "resizeableActivity - all"
        )
    ),
    Slide.BulletList(
        title = "Key Changes in SDK 37 (Android 17)",
        items = listOf(
            "When running on a large screen (smaller dimension ≥ 600dp), the following attributes and APIs will be ignored",
            "screenOrientation - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
            "setRequestedOrientation() - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
            "resizeableActivity - all",
            "minAspectRatio - all"
        )
    ),
    Slide.BulletList(
        title = "Key Changes in SDK 37 (Android 17)",
        items = listOf(
            "When running on a large screen (smaller dimension ≥ 600dp), the following attributes and APIs will be ignored",
            "screenOrientation - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
            "setRequestedOrientation() - portrait, reversePortrait, sensorPortrait, userPortrait, landscape, reverseLandscape, sensorLandscape, userLandscape",
            "resizeableActivity - all",
            "minAspectRatio - all",
            "maxAspectRatio - all"
        )
    ),
    Slide.TextAndImage(
        title = "Android as a Desktop OS",
        bullets = listOf(
            "Android 17: Desktop Mode is no longer 'experimental.'",

        ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android as a Desktop OS",
        bullets = listOf(
            "Android 17: Desktop Mode is no longer 'experimental.'",
            "Taskbars, Status bars, and floating windows are the standard.",

        ),
        image = Res.drawable.android_devices
    ),
    Slide.BulletList(
        title = "What you should all be doing today!",
        items = listOf(
            "Input Abstraction: Start treating \"Input\" as a generic event.",
        )
    ),
    Slide.BulletList(
        title = "What you should all be doing today!",
        items = listOf(
            "Input Abstraction: Start treating \"Input\" as a generic event.",
            "Whether it's a click, a remote control press, or a gaze-pinch in XR, the business logic should remain agnostic."
        )
    ),
    Slide.Code(
        title = "Hardcoded to Touch",
        codeSnippet = """
            @Composable
            fun LegacyButton(onMessageSent: (String) -> Unit) {
                var text by remember { mutableStateOf("") }
                Button(
                    // This is explicitly a "Click" event. 
                    // Hard to map to a "Gaze + Pinch" or a "D-Pad Center" 
                    // without extra boilerplate.
                    onClick = { 
                        if (text.isNotBlank()) onMessageSent(text) 
                    }
                ) {
                    Text("Send Message")
                }
            }
        """.trimIndent()
    ),
    Slide.Code(
        title = "Intent-Based Input (Agnostic)",
        codeSnippet = """
            sealed interface UserIntent {
                data class SendMessage(val content: String) : UserIntent
                object Cancel : UserIntent
            }
            @Composable
            fun ModernInputComponent(onIntent: (UserIntent) -> Unit) {
                val textState = remember { mutableStateOf("") }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusable()
                        .onKeyEvent { keyEvent ->
                            if (keyEvent.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                                onIntent(UserIntent.SendMessage(textState.value))
                                true
                            } else false
                        }
                        .combinedClickable(
                            onClick = { onIntent(UserIntent.SendMessage(textState.value)) }
                        )
                ) {
                    // UI Representation
                    AdaptiveInputBar(state = textState)
                }
            }
        """.trimIndent()
    ),

    Slide.TextAndImage(
        title = "Android as a Desktop OS",
        bullets = listOf(
            "Android 17: Desktop Mode is no longer 'experimental.'",
            "Taskbars, Status bars, and floating windows are the standard.",
            "Drag-and-Drop is the new 'Copy-Paste'—support it for text and files!",

            ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android as a Desktop OS",
        bullets = listOf(
            "Android 17: Desktop Mode is no longer 'experimental.'",
            "Taskbars, Status bars, and floating windows are the standard.",
            "Drag-and-Drop is the new 'Copy-Paste'—support it for text and files!",
            "Handle 'Edge-to-Edge'—the system now ignores your status bar offsets."
        ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android in the Cockpit (AAOS)",
        bullets = listOf(
            "The 2-Second Blink Test: If they can't do it in 2s, the OS blocks your UI.",

            ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android in the Cockpit (AAOS)",
        bullets = listOf(
            "The 2-Second Blink Test: If they can't do it in 2s, the OS blocks your UI.",
            "Templates > Custom UI: Use the Car App Library to stay safety-compliant.",

            ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android in the Cockpit (AAOS)",
        bullets = listOf(
            "The 2-Second Blink Test: If they can't do it in 2s, the OS blocks your UI.",
            "Templates > Custom UI: Use the Car App Library to stay safety-compliant.",
            "Voice-First: In 2026, the best Car UI is the one you never have to touch.",
        ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android in the Cockpit (AAOS)",
        bullets = listOf(
            "The 2-Second Blink Test: If they can't do it in 2s, the OS blocks your UI.",
            "Templates > Custom UI: Use the Car App Library to stay safety-compliant.",
            "Voice-First: In 2026, the best Car UI is the one you never have to touch.",
            "Logic Sharing: Your KMP 'Brain' should power the phone app AND the car dashboard."
        ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android XR: The Spatial Frontier",
        bullets = listOf(
            "Be a 'Good Guest': Don't block the user's view of their own living room.",
        ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android XR: The Spatial Frontier",
        bullets = listOf(
            "Be a 'Good Guest': Don't block the user's view of their own living room.",
            "Z-Space: Even 2D apps now have 'Depth' layers in a 3D environment.",
        ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android XR: The Spatial Frontier",
        bullets = listOf(
            "Be a 'Good Guest': Don't block the user's view of their own living room.",
            "Z-Space: Even 2D apps now have 'Depth' layers in a 3D environment.",
            "Spatial Persistence: Start a task on your phone, put on your glasses, and finish it in 3D space.",

        ),
        image = Res.drawable.android_devices
    ),
    Slide.TextAndImage(
        title = "Android XR: The Spatial Frontier",
        bullets = listOf(
            "Be a 'Good Guest': Don't block the user's view of their own living room.",
            "Z-Space: Even 2D apps now have 'Depth' layers in a 3D environment.",
            "Spatial Persistence: Start a task on your phone, put on your glasses, and finish it in 3D space.",
            "Passkeys across devices: Biometrics must persist from the watch to the headset."
        ),
        image = Res.drawable.android_devices
    ),

    Slide.Title(
        title = "Beyond the Smartphone",
        subtitle = "We are more than just Mobile Developers"
    ),
    Slide.Title(
        title = "Beyond the Smartphone",
        subtitle = "We are edge computing developers, utilising Kotlin."
    ),
    Slide.Title(
        title = "Beyond the Smartphone",
        subtitle = "The \"Identity Crisis\" isn't a problem to be solved—it’s an opportunity."
    ),
    Slide.Title(
        title = "Beyond the Smartphone",
        subtitle = "Android has won the battle of being the most versatile OS on the planet. \n It is no longer just a mobile OS. \n Our job is to finally start acting like it."
    ),
    Slide.TextAndImage(
        title = "View the slides and find me!",
        bullets = listOf(
            "I'm @devwithzachary across the internet",
            "links.zpweb.site",
            "QR code for slides!",
        ),
        image = Res.drawable.github_qr,
    ),
    Slide.Title(
        title = "Thank you!",
        subtitle = "That's all folks... now on with the giveaway!."
    ),
)