# DefaultApi

All URIs are relative to *https://rest.nexmo.com/sms*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**sendAnSms**](DefaultApi.md#sendAnSms) | **POST** /{format} | Send an SMS |


<a id="sendAnSms"></a>
# **sendAnSms**
> SendAnSms200Response sendAnSms(format, apiKey, from, to, apiSecret, sig, text, ttl, statusReportReq, paramCallback, messageClass, type, body, udh, protocolId, clientRef, accountRef, entityId, contentId)

Send an SMS

Send an outbound SMS from your Vonage account

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val format : kotlin.String = json // kotlin.String | The format of the response
val apiKey : kotlin.String = apiKey_example // kotlin.String | Your API key
val from : kotlin.String = from_example // kotlin.String | The name or number the message should be sent from. Alphanumeric senderID's are not supported in all countries, see [Global Messaging](/messaging/sms/guides/global-messaging#country-specific-features) for more details. If alphanumeric, spaces will be ignored. Numbers are specified in E.164 format.
val to : kotlin.String = to_example // kotlin.String | The number that the message should be sent to. Numbers are specified in E.164 format.
val apiSecret : kotlin.String = apiSecret_example // kotlin.String | Your API secret. Required unless `sig` is provided
val sig : kotlin.String = sig_example // kotlin.String | The hash of the request parameters in alphabetical order, a timestamp and the signature secret. See [Signing Requests](/getting-started/concepts/signing-messages) for more details.
val text : kotlin.String = text_example // kotlin.String | The body of the message being sent. If your message contains characters that can be encoded according to the GSM Standard and Extended tables then you can set the `type` to `text`. If your message contains characters outside this range, then you will need to set the `type` to `unicode`.
val ttl : kotlin.Int = 56 // kotlin.Int | **Advanced**: The duration in milliseconds the delivery of an SMS will be attempted. By default Vonage attempts delivery for 72 hours, however the maximum effective value depends on the operator and is typically 24 - 48 hours. We recommend this value should be kept at its default or at least 30 minutes.
val statusReportReq : kotlin.Boolean = true // kotlin.Boolean | **Advanced**: Boolean indicating if you like to receive a [Delivery Receipt](/messaging/sms/building-blocks/receive-a-delivery-receipt).
val paramCallback : kotlin.String = paramCallback_example // kotlin.String | **Advanced**: The webhook endpoint the delivery receipt for this sms is sent to. This parameter overrides the webhook endpoint you set in Dashboard. Max 100 characters.
val messageClass : kotlin.Int = 56 // kotlin.Int | **Advanced**: The Data Coding Scheme value of the message
val type : kotlin.String = type_example // kotlin.String | **Advanced**: The format of the message body
val body : kotlin.String = body_example // kotlin.String | **Advanced**: Hex encoded binary data. Depends on `type` parameter having the value `binary`.
val udh : kotlin.String = udh_example // kotlin.String | **Advanced**: Your custom Hex encoded [User Data Header](https://en.wikipedia.org/wiki/User_Data_Header). Depends on `type` parameter having the value `binary`.
val protocolId : kotlin.Int = 56 // kotlin.Int | **Advanced**: The value of the [protocol identifier](https://en.wikipedia.org/wiki/GSM_03.40#Protocol_Identifier) to use. Ensure that the value is aligned with `udh`.
val clientRef : kotlin.String = clientRef_example // kotlin.String | **Advanced**: You can optionally include your own reference of up to 100 characters.
val accountRef : kotlin.String = accountRef_example // kotlin.String | **Advanced**: An optional string used to identify separate accounts using the SMS endpoint for billing purposes. To use this feature, please email [support](mailto:${CUSTOMER_SUPPORT_EMAIL})
val entityId : kotlin.String = entityId_example // kotlin.String | **Advanced**: A string parameter that satisfies regulatory requirements when sending an SMS to specific countries. For more information please refer to the [Country-Specific Outbound SMS Features](https://api.support.vonage.com/hc/en-us/articles/115011781468)
val contentId : kotlin.String = contentId_example // kotlin.String | **Advanced**: A string parameter that satisfies regulatory requirements when sending an SMS to specific countries. For more information please refer to the [Country-Specific Outbound SMS Features](https://api.support.vonage.com/hc/en-us/articles/115011781468)
try {
    val result : SendAnSms200Response = apiInstance.sendAnSms(format, apiKey, from, to, apiSecret, sig, text, ttl, statusReportReq, paramCallback, messageClass, type, body, udh, protocolId, clientRef, accountRef, entityId, contentId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#sendAnSms")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#sendAnSms")
    e.printStackTrace()
}
```

### Parameters
| **format** | **kotlin.String**| The format of the response | [default to json] [enum: json, xml] |
| **apiKey** | **kotlin.String**| Your API key | |
| **from** | **kotlin.String**| The name or number the message should be sent from. Alphanumeric senderID&#39;s are not supported in all countries, see [Global Messaging](/messaging/sms/guides/global-messaging#country-specific-features) for more details. If alphanumeric, spaces will be ignored. Numbers are specified in E.164 format. | |
| **to** | **kotlin.String**| The number that the message should be sent to. Numbers are specified in E.164 format. | |
| **apiSecret** | **kotlin.String**| Your API secret. Required unless &#x60;sig&#x60; is provided | [optional] |
| **sig** | **kotlin.String**| The hash of the request parameters in alphabetical order, a timestamp and the signature secret. See [Signing Requests](/getting-started/concepts/signing-messages) for more details. | [optional] |
| **text** | **kotlin.String**| The body of the message being sent. If your message contains characters that can be encoded according to the GSM Standard and Extended tables then you can set the &#x60;type&#x60; to &#x60;text&#x60;. If your message contains characters outside this range, then you will need to set the &#x60;type&#x60; to &#x60;unicode&#x60;. | [optional] |
| **ttl** | **kotlin.Int**| **Advanced**: The duration in milliseconds the delivery of an SMS will be attempted. By default Vonage attempts delivery for 72 hours, however the maximum effective value depends on the operator and is typically 24 - 48 hours. We recommend this value should be kept at its default or at least 30 minutes. | [optional] [default to 259200000] |
| **statusReportReq** | **kotlin.Boolean**| **Advanced**: Boolean indicating if you like to receive a [Delivery Receipt](/messaging/sms/building-blocks/receive-a-delivery-receipt). | [optional] [default to true] |
| **paramCallback** | **kotlin.String**| **Advanced**: The webhook endpoint the delivery receipt for this sms is sent to. This parameter overrides the webhook endpoint you set in Dashboard. Max 100 characters. | [optional] |
| **messageClass** | **kotlin.Int**| **Advanced**: The Data Coding Scheme value of the message | [optional] [enum: 0, 1, 2, 3] |
| **type** | **kotlin.String**| **Advanced**: The format of the message body | [optional] [default to text] [enum: text, binary, unicode] |
| **body** | **kotlin.String**| **Advanced**: Hex encoded binary data. Depends on &#x60;type&#x60; parameter having the value &#x60;binary&#x60;. | [optional] |
| **udh** | **kotlin.String**| **Advanced**: Your custom Hex encoded [User Data Header](https://en.wikipedia.org/wiki/User_Data_Header). Depends on &#x60;type&#x60; parameter having the value &#x60;binary&#x60;. | [optional] |
| **protocolId** | **kotlin.Int**| **Advanced**: The value of the [protocol identifier](https://en.wikipedia.org/wiki/GSM_03.40#Protocol_Identifier) to use. Ensure that the value is aligned with &#x60;udh&#x60;. | [optional] |
| **clientRef** | **kotlin.String**| **Advanced**: You can optionally include your own reference of up to 100 characters. | [optional] |
| **accountRef** | **kotlin.String**| **Advanced**: An optional string used to identify separate accounts using the SMS endpoint for billing purposes. To use this feature, please email [support](mailto:${CUSTOMER_SUPPORT_EMAIL}) | [optional] |
| **entityId** | **kotlin.String**| **Advanced**: A string parameter that satisfies regulatory requirements when sending an SMS to specific countries. For more information please refer to the [Country-Specific Outbound SMS Features](https://api.support.vonage.com/hc/en-us/articles/115011781468) | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **contentId** | **kotlin.String**| **Advanced**: A string parameter that satisfies regulatory requirements when sending an SMS to specific countries. For more information please refer to the [Country-Specific Outbound SMS Features](https://api.support.vonage.com/hc/en-us/articles/115011781468) | [optional] |

### Return type

[**SendAnSms200Response**](SendAnSms200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json, text/xml

