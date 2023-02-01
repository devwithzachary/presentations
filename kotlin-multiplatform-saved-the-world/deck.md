---
marp: false
header: 'How We Moved SDKs to Kotlin Multiplatform  and saved the world'
footer: 'androiddev.social@devwithzachary / @ishley30'
theme: default
---

# How We Moved SDKs to Kotlin Multiplatform 
## and saved the world (kind of)

---

## Intros
# Ashley Arthur
## Software Dev Engineer 
The brains behind the talk
@ishley30

![bg right:40% cover](images/ashley.jpeg) 

---

## Intros
# Zachary Powell
## ~~Sr Android Developer Advocate~~ Manager, DevRel
The one that gets to talk to you. 
androiddev.social@devwithzachary

![bg right:40% ](images/me-talk.jpeg) 

---

# Takeaways

![bg right:40%](images/pizza.jpeg) 

---

## Takeaways

# Not another Kotlin Multiplatform code talk.  

![bg right:40%](images/cross.png) 

---

## Takeaways

# Real world example of a team building a library in Kotlin Multiplatform

![bg right:40%](images/tick.png) 

---

## Takeaways

# Learn from the pain

![bg right:40% contain](images/painscale.jpeg) 

* History of the SDK's
* Past attempts at codeshare

---

## Takeaways

# See the success!

![bg right:40% contain](images/states-of-a-programmer.png) 

* Main changes from old codeshare
* The SDKs now
* Suprising improvements

---

# What are the Vonage Client SDKs?

![bg right:40% contain](images/Vonage_Logo_black.png) 

---

## What are the Vonage Client SDKs?

# Android, iOS and JS SDKs

![bg right:40% contain](images/clients.png) 

---

## What are the Vonage Client SDKs?

# Wrappers for the Vonage REST/WebRTC APIs

![bg right:40% contain](images/Vonage-API-Platform.svg) 

---

## What are the Vonage Client SDKs?

# Make it easier to use the Vonage APIs in a native friendly way
# Developers are our world.

![bg right:40% contain](images/voice.svg) 

---

## <span style="color:white;">History Lesson</span> 

# <span style="color:yellow;">A long time ago in a tech company far, far away....</span> 

![bg ](images/space.jpg) 

---

* Three native SDK's, Android, iOS, JS all separate
* Tough to test across all platforms
* New features written by three separate teams
* 3x the work to implement something new

![bg right:40% contain](images/nexmo-logo.png)

---


# Nexmo was bought by Vonage.

![bg right:40% contain](images/nexmo-vonage.jpeg)

---

# Rewrite!

![bg right:40% contain](images/SANDCASTLES.png)

---

## Kotlin Multiplatform try 1

* JS team took a look at Kotlin Multiplatform at a VERY early stage
* They wanted to rebuild EVERYTHING in Kotlin Multiplatform
* This failed.
* But we still want shared code!

![bg right:40% contain](images/kotlin-text.png)

---

## Enter C++

* Allowed for some codeshare
* Base level with platform specific code written on top.

![bg right:40% contain](images/c++.png)

---

# Happy Codeshare! Right?!

![bg right:40% contain](images/happy.jpeg)

---

# <!--fit--> No.

---

## Or Not.

* Still had three separate code bases on top of the C++ layer
* C++ code wasn't accessible to all on the team. 
* Very slow builds limiting release cadence

![bg right:40% contain](images/codeshare.png)

---

# Rewrite!

![bg right:40% ](images/tired.png)

---

## But with what?

* Shared code, just better
* Share business logic, not low-level platform stuff

![bg right:40% contain](images/perfect.png)

---

## What options?

![bg right:40% contain](images/options.png)

---

# <!--fit-->  No. Please. No.

---

## Rust

* Very powerful
* Good shared codebase option
* Doesn't solve binding issues. 
* Tooling for native was relatively unknown.

![bg right:40% contain](images/rust.png)

---

## Kotlin Multiplatform

* Also a very good option for shared codebase
* Bindings solved! 
* Let's Prototype

![bg right:40% contain](images/kotlin-text.png)

---

## Prototype

* December 2021, Perfect time to hide and build the prototype.
* Very careful about what to put into the shared code
* Kotlin Multiplatform for business logic. Platform specific code stays out!

![bg right:40% contain](images/perfect.png)

---

## Platform Specific

* Networking - HTTP client, WebSocket, WebRTC client.
* Platform specific exposed behind interfaces for Kotlin Multiplatform to access.

![bg right:40% contain](images/webrtc.png)

---

## Prototype delivered!

# And it worked!

![bg right:40% contain](images/SANDCASTLES.png)

---

#  <!--fit--> Then drama!

---

# Ashley dared to have a baby (congratulations)

![bg right:40%](images/surpise.jpeg)

---

# Team members left

![bg right:40%](images/deadpool.jpeg)

---

# Team had to focus on bug fixing in the current SDK

![bg right:40%](images/startrek.jpeg)

---

# <!--fit-->  But wait!

---

# The team is reminded of the pain points

![bg right:40%](images/cry.jpeg)

---

# Ashley returns! 

![bg right:40%](images/ash.jpeg)

---

# <!--fit-->  “Sod it let's do it” - Ashley

---

## From Prototype to SDK

# What needed to happen?

![bg right:40%](images/prototype.png)

---

# Focus had just been on iOS and Android, JS was needed as well!

![bg right:40%](images/js.png)

---

## I asked the team
# What were the main changes?

---

# Team had to learn Kotlin 
mix of Android, iOS and JS devs

![bg right:40% contain](images/kotlin-text.png)

---

# All in on Gradle

This made iOS devs sad.

![bg right:40% contain](images/gradle.png)

---

# Shift in tooling, moving to a new IDE 

A lot of the team had been using their own preferred IDE/text editors for the shared C++ code.

![bg right:40% contain](images/androidstudio.png)

---

## Today!

# Vonage Client SDK for Voice released!

Vonage Client SDK for Chat releasing end of Q1

![bg right:40% ](images/fireworks.jpg)

---

## Lessons Learnt / Reflection

# What changed?

---

# Keep up to date with Kotlin updates

Language still getting large updates

![bg right:40% contain](images/Calendar-Reminder.png)

---

# Original pain point of consistency has been removed!

Write once for everywhere!

![bg right:40% contain](images/Technical-Blog-Writing.png)

---

# Platform code is just exposing the functionality 

More time to work on improving the API contract and making the SDK a joy to use!

![bg right:40% contain](images/Communications-Apps-2.png)

---

# Everyone knows Kotlin, anyone can build a feature 

unlike before with C++/SDK

![bg right:40% contain](images/Women-in-Tech.png)

---

# Move to a Mono repo

Whole team synced across all platforms

![bg right:40% contain](images/Team-Work.png)

---

# We have tests! 

Tests are the key to saving developers (which are our world!)

![bg right width:500px](images/Globe-Arrows.png)

---

# Go check out the SDKs

Coupon Code, €10 free credit: <b>XXXXXXX</b>

developer.vonage.com

github.com/Vonage-Community/tutorials-client_sdk-ios-android-js

![bg right:40% width:400px](images/github.SVG)

---

# Thank you!

![width:200px](images/me.jpg) 

![bg right:40% width:500px](images/qr-code.png)

polywork.com/devwithzachary

github.com/devwithzachary/presentations