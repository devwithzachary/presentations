# 📱 Android's Identity Crisis (2026)
### A Kotlin Multiplatform Presentation Deck

**"The Medium is the Message."**

This repository contains the source code for the presentation **"Android's Identity Crisis in 2026"**. Instead of using Keynote or PowerPoint, this entire slide deck is built as a **Kotlin Multiplatform (KMP) application**.

It demonstrates the core thesis of the talk: **We are no longer just Android Mobile Developers; we are Engineers building for a ubiquitous platform.**

## 🚀 Features

This project is a living example of the flexibility of Kotlin Multiplatform:

* **Multi-Target Deployment:**
  * **🖥️ Desktop (macOS/Windows/Linux):** Optimized for projectors with keyboard/clicker support and responsive scaling.
  * **📱 Android:** Optimized for handheld use with touch navigation and adaptive layouts.
* **Interactive Slides:**
  * **Device Simulator:** A live demo that morphs the UI between Phone, Tablet, Watch, and Auto form factors.
  * **Reactive Code Playground:** A split-screen view where interacting with the UI updates the displayed code in real-time.
* **Custom Engine:**
  * **Syntax Highlighting:** A lightweight, Regex-based Kotlin syntax highlighter built purely in Compose.
  * **Responsive Typography:** Text scales dynamically based on the window size to ensure readability on large screens.
  * **Smooth Transitions:** Custom `FastOutSlowIn` animations with depth and fade effects.

## 🛠 Project Structure

The project follows a Clean Architecture approach to separate the presentation content from the rendering logic.

```text
composeApp/src/commonMain/kotlin/
├── App.kt                      // Entry point & Navigation Logic
│
├── model/                      // Data Layer
│   ├── SlideModel.kt           // Sealed Interface defining slide types
│   └── PresentationContent.kt  // The actual slide deck content
│
├── ui/                         // View Layer
│   ├── theme/                  // Design System & Responsive Typography
│   ├── renderer/               // The "Engine" (SlideRenderer, SyntaxHighlighter)
│   └── components/             // Interactive Components (DeviceSimulator, Playground)
```

## ⚡ Getting Started

### Prerequisites
* **JDK 21** (Required for the Gradle Daemon).
* **Android Studio** (Koala Feature Drop or newer).
* **Kotlin Multiplatform Mobile** plugin installed.

### 1. Run on Desktop (The Presentation)
You can run the desktop app directly from the terminal or IDE.

**Via Terminal:**
```bash
./gradlew desktopRun
```

**Via Android Studio:**
1.  Select **`desktopRun`** from the Run Configurations dropdown.
2.  Click **Play** (▶).

### 2. Run on Android (The Reference)
1.  Connect your Android device or start an emulator.
2.  Select **`androidApp`** from the Run Configurations dropdown.
3.  Click **Play** (▶).

## 🎮 Controls

The Desktop application is designed to work with standard presentation clickers.

| Action | Key / Input |
| :--- | :--- |
| **Next Slide** | `Right Arrow`, `Space`, `Page Down` (Clicker), `Enter` |
| **Previous Slide** | `Left Arrow`, `Page Up` (Clicker), `Backspace` |
| **Interactive Elements** | Mouse Click / Touch |

## 🧩 Key Implementation Details

### The "Identity Crisis" Simulator
Located in `ui/components/InteractiveDemoSlide.kt`.
This component uses `animateDpAsState` to smoothly resize a container, demonstrating how a single Compose UI can adapt to:
* **Phone:** `360.dp` width (List Layout)
* **Tablet:** `800.dp` width (Grid Layout)
* **Watch:** `200.dp` round (Minimal Layout)

### Responsive Typography
Located in `ui/theme/PresentationTheme.kt`.
We calculate a `scaleFactor` based on the current window width relative to a standard 1920px screen. This ensures that whether the window is small or fullscreen on a 4K projector, the text remains proportional and readable.

## 📜 License

This project is open source and available under the [MIT License](LICENSE).

---

> *"The future of Android development is not about the OS, but the UI toolkit that transcends it."*