
# InboundMessage

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **apiKey** | **kotlin.String** | The Vonage API Key of the receiving account. |  |
| **msisdn** | **kotlin.String** | The phone number that this inbound message was sent from. Numbers are specified in E.164 format. |  |
| **to** | **kotlin.String** | The phone number the message was sent to. **This is your virtual number**. Numbers are specified in E.164 format. |  |
| **messageId** | **kotlin.String** | The ID of the message |  |
| **text** | **kotlin.String** | The message body for this inbound message. |  |
| **type** | **kotlin.String** | Possible values are:    - &#x60;text&#x60; - standard text.   - &#x60;unicode&#x60; - URLencoded   unicode  . This is valid for standard GSM, Arabic, Chinese, double-encoded characters and so on.   - &#x60;binary&#x60; - a binary message.  |  |
| **keyword** | **kotlin.String** | The first word in the message body. Converted to upper case. |  |
| **messageTimestamp** | **kotlin.String** | The time when Vonage started to push this Delivery Receipt to your webhook endpoint. |  |
| **timestamp** | **kotlin.String** | A unix timestamp representation of message-timestamp. |  [optional] |
| **nonce** | **kotlin.String** | A random string that forms part of the signed set of parameters, it adds an extra element of unpredictability into the signature for the request. You use the nonce and timestamp parameters with your shared secret to calculate and validate the signature for inbound messages. |  [optional] |
| **concat** | **kotlin.String** | True - if this is a concatenated message. This field does not exist if it is a single message |  [optional] |
| **concatRef** | **kotlin.String** | The transaction reference. All parts of this message share this value. |  [optional] |
| **concatTotal** | **kotlin.String** | The number of parts in this concatenated message. |  [optional] |
| **concatPart** | **kotlin.String** | The number of this part in the message. Counting starts at 1. |  [optional] |
| **&#x60;data&#x60;** | [**org.openapitools.client.infrastructure.OctetByteArray**](org.openapitools.client.infrastructure.OctetByteArray.md) | The content of this message, if type is binary. |  [optional] |
| **udh** | **kotlin.String** | The hex encoded User Data Header, if type is binary |  [optional] |



