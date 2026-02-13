package com.vonage.sms

import org.openapitools.client.apis.DefaultApi
import org.openapitools.client.infrastructure.*
import org.openapitools.client.models.*

class SMS {
    private val platform = getPlatform()

    suspend fun sendSMS(text: String): String {

        val textToSend = "$text, sent from: ${platform.name}!"
        try {
            val format = DefaultApi.FormatSendAnSms.json // kotlin.String | The format of the response
            val apiKey : String = VONAGE_API_KEY // kotlin.String | Your API key
            val from : String = VONAGE_FROM // kotlin.String | The name or number the message should be sent from. Alphanumeric senderID's are not supported in all countries, see [Global Messaging](/messaging/sms/guides/global-messaging#country-specific-features) for more details. If alphanumeric, spaces will be ignored. Numbers are specified in E.164 format.
            val to : String = VONAGE_TO // kotlin.String | The number that the message should be sent to. Numbers are specified in E.164 format.
            val apiSecret : String = VONAGE_API_SECRET // kotlin.String | Your API secret. Required unless `sig` is provided
            val sig = null // kotlin.String | The hash of the request parameters in alphabetical order, a timestamp and the signature secret. See [Signing Requests](/getting-started/concepts/signing-messages) for more details.
            val ttl = null // kotlin.Int | **Advanced**: The duration in milliseconds the delivery of an SMS will be attempted. By default Vonage attempts delivery for 72 hours, however the maximum effective value depends on the operator and is typically 24 - 48 hours. We recommend this value should be kept at its default or at least 30 minutes.
            val statusReportReq = null // kotlin.Boolean | **Advanced**: Boolean indicating if you like to receive a [Delivery Receipt](/messaging/sms/building-blocks/receive-a-delivery-receipt).
            val paramCallback = null // kotlin.String | **Advanced**: The webhook endpoint the delivery receipt for this sms is sent to. This parameter overrides the webhook endpoint you set in Dashboard. Max 100 characters.
            val messageClass = null // kotlin.Int | **Advanced**: The Data Coding Scheme value of the message
            val type = null // kotlin.String | **Advanced**: The format of the message body
            val body = null // kotlin.String | **Advanced**: Hex encoded binary data. Depends on `type` parameter having the value `binary`.
            val udh = null // kotlin.String | **Advanced**: Your custom Hex encoded [User Data Header](https://en.wikipedia.org/wiki/User_Data_Header). Depends on `type` parameter having the value `binary`.
            val protocolId = null // kotlin.Int | **Advanced**: The value of the [protocol identifier](https://en.wikipedia.org/wiki/GSM_03.40#Protocol_Identifier) to use. Ensure that the value is aligned with `udh`.
            val clientRef = null // kotlin.String | **Advanced**: You can optionally include your own reference of up to 100 characters.
            val accountRef = null // kotlin.String | **Advanced**: An optional string used to identify separate accounts using the SMS endpoint for billing purposes. To use this feature, please email [support](mailto:${CUSTOMER_SUPPORT_EMAIL})
            val entityId = null // kotlin.String | **Advanced**: A string parameter that satisfies regulatory requirements when sending an SMS to specific countries. For more information please refer to the [Country-Specific Outbound SMS Features](https://api.support.vonage.com/hc/en-us/articles/115011781468)
            val contentId = null // kotlin.String | **Advanced**: A string parameter that satisfies regulatory requirements when sending an SMS to specific countries. For more information please refer to the [Country-Specific Outbound SMS Features](https://api.support.vonage.com/hc/en-us/articles/115011781468)
            
            val apiInstance = DefaultApi()
            val result = apiInstance.sendAnSms(format, apiKey, from, to, apiSecret, sig, textToSend, ttl, statusReportReq, paramCallback, messageClass, type, body, udh, protocolId, clientRef, accountRef, entityId, contentId)
            println(result)
        } catch (e: Exception) {
            return e.printStackTrace().toString()
        } 
        return textToSend
    }
}