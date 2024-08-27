
# Message

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **to** | **kotlin.String** | The number the message was sent to. Numbers are specified in E.164 format. |  [optional] |
| **messageId** | **kotlin.String** | The ID of the message |  [optional] |
| **status** | **kotlin.String** | The status of the message. See [Troubleshooting Failed SMS](/messaging/sms/guides/troubleshooting-sms). |  [optional] |
| **remainingBalance** | **kotlin.String** | Your estimated remaining balance |  [optional] |
| **messagePrice** | **kotlin.String** | The estimated cost of the message |  [optional] |
| **network** | **kotlin.String** | The estimated ID of the network of the recipient |  [optional] |
| **clientRef** | **kotlin.String** | If a &#x60;client-ref&#x60; was included when sending the SMS, this field will be included and hold the value that was sent. |  [optional] |
| **accountRef** | **kotlin.String** | **Advanced**: An optional string used to identify separate accounts using the SMS endpoint for billing purposes. To use this feature, please email [support](mailto:${CUSTOMER_SUPPORT_EMAIL}) |  [optional] |



