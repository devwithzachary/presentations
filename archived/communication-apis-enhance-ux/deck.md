---
marp: true
header: 'Using Communication APIs to enhance your UX'
footer: '@devwithzachary@androiddev.social'
theme: default
---

# Using Communication APIs to enhance your UX
And reduce notifications!

---

# Who am I?

- Sr Android Developer Advocate at Vonage
- Android Developer for 12+ years
- DevRel for 2 years
- Pet Dad

![bg right ](images/pets.png)

---

# Who am I?

- ~~Sr Android Developer Advocate~~ DevRel Manager at Vonage
- Android Developer for 12+ years
- DevRel for 2 years
- Pet Dad

![bg right ](images/pets.png)

---

## Android
# Other platforms are available

![bg right width:400px](images/clients.png)

---

## Takeaways

* History of notifications on Android
* Why today notifications suck!
* What are communication APIs?
* How might you use them in your applications?

![bg right width:400px](images/pizza.jpeg)

---

# In the beginning there was... notifications!

![bg right width:400px](images/Android10r1notifs.png)

---

## It was great!

# Quick access to important information

![bg right width:400px](images/notification-progressbar_2x.png)

---

## It was great!

# Push content to users while the app is closed

![bg right width:400px](images/important.png)

---

## It was great!

# Access to controls for music apps.

![bg right width:300px](images/music_controls.png)

---

# Look at your phone. 
# How many notifications do you have right now?

---

# <!--fit--> 5?

---

# <!--fit--> 10?

---

# <!--fit--> 32767?

---

![bg width:400px](images/notification-fold.png)

---

## Then it wasn't great.

# Users bombarded with notifications. **Avg 46 per day**

 <font size=3> Source: Businessofapp.com</font> 


![bg right width:400px](images/notification-fold.png)

<!--
Stats source: https://www.businessofapps.com/marketplace/push-notifications/research/push-notifications-statistics/
-->
---

## Then it wasn't great.

# Notifications treated like spam. **Reaction rate 4.6%**

 <font size=3> Source: Businessofapp.com</font> 


![bg right width:400px](images/notification-fold.png)

<!--
Stats source: https://www.businessofapps.com/marketplace/push-notifications/research/push-notifications-statistics/
-->
---

## Then it wasn't great.

# UX nightmare

![bg right width:400px](images/notification-fold.png)

---

## Control is Yours!

# Android introduces ways for users to mute/stop notifications

![bg right width:300px](images/Notification-Importance-Controls-Android-Oreo-12.webp)

---

## Control is Yours!

# Great UX! But at what cost?

![bg right width:300px](images/Notification-Importance-Controls-Android-Oreo-12.webp)

---

## Terrible for Developers

# Users completely shut off notifications

![bg right width:300px](images/Notifications_Android_7_3.webp)

---

## Terrible for Developers

# Can't rely on notifications for important stuff!

![bg right width:300px](images/Notifications_Android_7_3.webp)

---

## Notifications for less important stuff

# Info that may or may not be seen by the user

![bg right width:400px](images/The-Android-90-Pie-notification-drawer-showing-four-different-kinds-of-notifications.ppm)

---

## Notifications for less important stuff

# Become used even more for 'spam'

![bg right width:400px](images/The-Android-90-Pie-notification-drawer-showing-four-different-kinds-of-notifications.ppm)

---

## But what about the important stuff?

# When you need a user to action something

![bg right width:400px](images/attention-vector-information-announcement-important-attention-please-alert-poster_41737-1002.webp)

---

## But what about the important stuff?

# Time sensative infomation

![bg right width:400px](images/attention-vector-information-announcement-important-attention-please-alert-poster_41737-1002.webp)

---

## But what about the important stuff?

# Start a Conversation Flow

![bg right width:400px](images/attention-vector-information-announcement-important-attention-please-alert-poster_41737-1002.webp)

---

## Conversation Flow

# Send notification, pray the user sees it

![bg right width:400px](images/bot.png)

---

## Conversation Flow

# Wait until they open the app (may or may not be 10+ years)

![bg right width:400px](images/bot.png)

---

## Conversation Flow

# Start conversation

![bg right width:400px](images/bot.png)

---

## Not a good User Experience

# Slow

![bg right width:500px](images/angry.webp)

---
## Not a good User Experience

# Requires a lot of steps

![bg right width:500px](images/angry.webp)

---
## Not a good User Experience

# May or may not be actioned

![bg right width:500px](images/angry.webp)

---
## Not a good User Experience

# What happens when the app isn't installed?

![bg right width:500px](images/angry.webp)

---

## How do we improve this?

# Better guarantee the user sees important info

![bg right width:600px](images/Vonage-API-Platform.svg)


---

## How do we improve this?

# Quickly start interactive conversations

![bg right width:600px](images/Vonage-API-Platform.svg)


---

## Communication APIs

# A way to provide new experiences

![bg right width:500px](images/Enterprise_Image.svg)

---

## Communication APIs

# Platform independent

![bg right width:500px](images/Enterprise_Image.svg)

---

## Text

# Send and receive Text Messages via code

![bg right width:500px](images/sms.svg)

---

## Voice

# App to App, App to Phone, Text to Speach

![bg right width:500px](images/voice.svg)

---

## Video

# Screen sharing, live streaming, meetings

![bg right width:500px](images/video.png)

---

# Vonage Communication APIs


![bg right width:500px](images/Vonage_Logo_black.png)

---

# SDKs

![bg centre width:500px](images/sdks.png)

---

# Restful APIs

```
curl -X "POST" "https://rest.nexmo.com/sms/json" \
  -d "from=$VONAGE_BRAND_NAME" \
  -d "text=A text message sent using the Vonage SMS API" \
  -d "to=$TO_NUMBER" \
  -d "api_key=$VONAGE_API_KEY" \
  -d "api_secret=$VONAGE_API_SECRET"
```

---



# Use Case - SMS Alerts

* Avg open rate **99%**
* Users select and receive important alerts
* Direct and actionable via in app linking

 <font size=3> Source: redeye.com</font> 

![bg right width:500px](images/sms.svg)

<!--
Stat source https://www.redeye.com/resources/sms-marketing-vs-email-marketing-who-wins-the-battle-for-effectiveness/
-->

---


# SMS Alerts 

* Stock alerts for high demand items
* User signs up via an app
* Selected SMS alerts
* Direct alerts sent even if the app is no longer installed

![bg right width:400px](images/ps5.webp)

<!--
Stat source https://www.redeye.com/resources/sms-marketing-vs-email-marketing-who-wins-the-battle-for-effectiveness/
-->

---

# SMS Alerts - NodeJS

```javascript
const from = VONAGE_BRAND_NAME
const to = TO_NUMBER
const text = 'PS5 is now in stock!'

await vonage.sms.send({to, from, text})
.then(resp => { 
    console.log('Message sent successfully'); 
    console.log(resp); 
})
.catch(err => { 
    console.log('There was an error sending the messages.'); 
    console.error(err); 
});
```

---

# Voice Help Desk

* Museum has a physical phone help desk
* Calling in foreign countries is expensive

![bg right width:500px](images/museum.jpeg)

---

# Voice Help Desk

* Build the "call" button into the app
* Audio call within the app
* User never leaves your app
* Process doesn't change 


![bg right width:500px](images/voice.svg)

---

# Voice Help Desk - Kotlin

```kotlin
var client = NexmoClient.Builder().build(this)
client.login("JWT")
client.serverCall("PHONE_NUMBER", 
    null, 
    object : NexmoRequestListener<NexmoCall> {
        override fun onSuccess(call: NexmoCall?) {}

        override fun onError(apiError: NexmoApiError) {}
    }
)
```

---

# In App Video Doctor

* Enable virtual 1:1 with doctor
* Doctor can see many more patients
* Still able to provide visual diagnosises

![bg right width:500px](images/doctor-video.png)

---

# In App Video Support

* User signs up to virtual doctor app
* Can book and directly video within the app
* User never leaves app

![bg right width:500px](images/video-doctor.jpeg)

---

# In App Video Support - Kotlin

```kotlin
private val sessionListener: Session.SessionListener = object : Session.SessionListener {
    override fun onConnected(session: Session) {
        publisher = Publisher.Builder(activity).build()
        session.publish(publisher)
    }
    override fun onStreamReceived(session: Session, stream: Stream) {
        if (subscriber == null) {
            subscriber = Subscriber.Builder(activity, stream).build()
            session.subscribe(subscriber)
        }
    }
    override fun onStreamDropped(session: Session, stream: Stream) {
        if (subscriber != null) {
            subscriber = null
        }
    }
}
session = Session.Builder(activity, apiKey, sessionId).build()
session?.setSessionListener(sessionListener)
session?.connect(token)
```

---


# Reducing notifications

![bg right width:400px](images/Android10r1notifs.png)

---

# Maximise Engagement

![bg right width:600px](images/Vonage-API-Platform.svg)

---

# Get started!

## Sign up at developer.vonage.com

![bg right width:600px](images/Vonage-API-Platform.svg)

---

# Thank you!

![width:200px](images/me.jpg) 

![bg right width:400px](images/qr-code.png)

polywork.com/devwithzachary

<font size=5>github.com/devwithzachary/presentations</font>