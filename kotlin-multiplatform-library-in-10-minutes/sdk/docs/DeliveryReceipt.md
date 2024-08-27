
# DeliveryReceipt

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **msisdn** | **kotlin.String** | The number the message was sent to. Numbers are specified in E.164 format. |  [optional] |
| **to** | **kotlin.String** | The SenderID you set in &#x60;from&#x60; in your request. |  [optional] |
| **networkCode** | **kotlin.String** | The Mobile Country Code Mobile Network Code (MCCMNC) of the carrier this phone number is registered with. |  [optional] |
| **messageId** | **kotlin.String** | The Vonage ID for this message. |  [optional] |
| **price** | **kotlin.String** | The cost of the message |  [optional] |
| **status** | **kotlin.String** | A code that explains where the message is in the delivery process. |  [optional] |
| **scts** | **kotlin.String** | When the DLR was received from the carrier in the following format &#x60;YYMMDDHHMM&#x60;. For example, &#x60;2001011400&#x60; is at &#x60;2020-01-01 14:00&#x60; |  [optional] |
| **errCode** | **kotlin.String** | The status of the request. Will be a non &#x60;0&#x60; value if there has been an error, or if the status is unknown. See the [Delivery Receipt documentation](/messaging/sms/guides/delivery-receipts#dlr-error-codes) for more details |  [optional] |
| **apiKey** | **kotlin.String** | The API key that sent the SMS. This is useful when multiple accounts are sending webhooks to the same endpoint. |  [optional] |
| **messageTimestamp** | **kotlin.String** | The time when Vonage started to push this Delivery Receipt to your webhook endpoint. |  [optional] |



