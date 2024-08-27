package com.vonage.sms

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform