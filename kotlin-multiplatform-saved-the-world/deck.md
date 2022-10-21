---
marp: true
header: 'How Vonage Moved its SDKs to KMP and saved the world (kind of)'
footer: 'Zachary Powell (@devwithzachary)/Ashley Arthur'
theme: default
---

# How Vonage Moved its Client SDKs to Kotlin Multiplatform 
## and saved the world 
## (kind of)

![bg right width:500px](images/kotlin-super-hero.png)

---

## Intros
# Ashley Arthur
## Software Dev Engineer 
The brains behind the talk

---

## Intros
# Zachary Powell
## ~~Sr Android Developer Advocate~~ Manager, DevRel
The one that gets to stand up here and talk to you.

![bg right width:500px](images/me-talk.jpeg) 

---

# Takeaways

![bg right width:600px](images/pizza.jpeg) 

---

## Takeaways

# Not another KMP code talk.  

![bg right width:300px](images/cross.png) 

---

## Takeaways

# A real world example of a team building a library in KMP

![bg right width:300px](images/tick.png) 

---

## Takeaways

# Learn from the pain

![bg right width:600px](images/painscale.jpeg) 

* History of the SDK's
* Past attempts at codeshare

---

## Takeaways

# See the success!

![bg right width:600px](images/states-of-a-programmer.png) 

* Improvements KMP made
* The SDKs now
* Suprising improvements

---

# What are the Vonage Client SDKs?

![bg right width:500px](images/Vonage_Logo_black.png) 

---

## What are the Vonage Client SDKs?

# Android, iOS and JS SDKs

![bg right width:500px](images/clients.png) 

---

## What are the Vonage Client SDKs?

# Wrappers for the Vonage REST/WebRTC APIs

![bg right width:500px](images/Vonage-API-Platform.svg) 

---

## What are the Vonage Client SDKs?

# Make it easier to use the Vonage APIs in a native friendly way

![bg right width:500px](images/voice.svg) 

---

## <span style="color:white;">History Lesson</span> 

# <span style="color:yellow;">A long time ago in a tech company far, far away....</span> 

![bg ](images/space.jpg) 

---

* Three native SDK's, Android, iOS, JS all separate
* Tough to test across all platforms
* New features written by three separate teams
* 3x the work to implement something new

![bg right width:500px](images/nexmo-logo.png)

---


# Nexmo was bought by Vonage.

![bg right width:500px](images/nexmo-vonage.jpeg)

---

# Rewrite!

![bg right width:500px](images/SANDCASTLES.png)

---

## Kotlin Multiplatform try 1

* JS team took a look at KMP at a VERY early stage
* They wanted to rebuild EVERYTHING in KMP
* This failed.
* But we still want shared code!

![bg right width:500px](images/kotlin-text.png)

---

## Enter C++

* Allowed for some codeshare
* Base level with platform specific code written on top.

![bg right width:400px](images/c++.png)

---

# Happy Codeshare! Right?!

![bg right width:600px](images/happy.jpeg)

---

# <!--fit--> No.

---

## Or Not.

* Still had three separate code bases on top of the C++ layer
* C++ code wasn't accessible to all on the team. 
* Very slow builds limiting release cadence

![bg right width:500px](images/codeshare.png)

---

# Rewrite!

![bg right width:600px](images/tired.png)

---

## But with what?

* Shared code, just better
* Share business logic, not low-level platform stuff

![bg right width:500px](images/perfect.png)

---

## What options?

![bg right width:500px](images/options.png)

---

# <!--fit-->  No. Please. No.

---

## Rust

* Very powerful
* Good shared codebase option
* Doesn't solve binding issues. 
* Tooling for native was relatively unknown.

![bg right width:500px](images/rust.png)

---

## Kotlin Multiplatform

* Also a very good option for shared codebase
* Bindings solved! 
* Let's Prototype

![bg right width:500px](images/kotlin-text.png)

---

## Prototype

* December 2021, Perfect time to hide and build the prototype.
* Very careful about what to put into the shared code
* KMP for business logic. Platform specific code stays out!

![bg right width:500px](images/perfect.png)

---

## Platform Specific

* Networking - HTTP client, WebSocket, WebRTC client.
* Platform specific exposed behind interfaces for KMP to access.

![bg right width:600px](images/webrtc.png)

---

## Prototype delivered!

# And it worked!

![bg right width:500px](images/SANDCASTLES.png)

---

#  <!--fit--> Then drama!

---

# Ashley dared to have a baby (congratulations)

![bg right width:500px](images/surpise.jpeg)

---

# Team members left

![bg right width:500px](images/deadpool.jpeg)

---

# Team had to focus on bug fixing in the current SDK

![bg right width:500px](images/startrek.jpeg)

---

# <!--fit-->  But wait!

---

# The team is reminded of the pain points

![bg right width:500px](images/cry.jpeg)

---

# Ashley returns! 

![bg right width:500px](images/ash.jpeg)

---

# <!--fit-->  “Sod it let's do it” - Ashley

---

## From Prototype to SDK

# What needed to happen?

---

# Focus had just been on iOS and Android, JS was needed as well!

![bg right width:500px](images/js.png)

---


# Main changes had nothing to do with writing Kotlin Multiplatform code

---

# Team had to learn Kotlin 
mix of Android, iOS and JS devs

![bg right width:500px](images/kotlin-text.png)

---

# All in on Gradle

This made iOS devs sad.

![bg right width:600px](images/gradle.png)

---

# Shift in tooling, moving to a new IDE 

A lot of the team had been using their own preferred IDE/text editors for the shared C++ code.

![bg right width:400px](images/androidstudio.png)

---

## Today!

# Vonage Client SDK for Voice in beta

With others coming soon™️

---

# Lessons Learnt / Reflection

---

# Keep up to date with Kotlin updates

still getting pretty large updates, but they are kept behind feature flags

---

# Original pain point of consistency has been removed!

---

# Platform code is just exposing the functionality 

More time to work on improving the API contract and making the SDK a joy to use!

---

# Everyone knows Kotlin, anyone can build a feature 

unlike before with C++/SDK

---

# Move to a Mono repo

---

# We have tests! 

(Tests are the key to saving the world.)

![bg right width:500px](images/kotlin-super-hero.png)

---

# Go check out the SDKs

developer.vonage.com/tools

![bg right width:400px](images/sdks.svg)

---

# See you at Droidcon!

![bg right width:400px](images/android-figs.jpeg)

---

# Thank you!

![width:200px](images/me.jpg) 

![bg right width:500px](images/qr-code.png)

polywork.com/devwithzachary

<font size=5>github.com/devwithzachary/presentations</font>