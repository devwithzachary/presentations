/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import org.openapitools.client.models.DeliveryReceipt

class DeliveryReceiptTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of DeliveryReceipt
        //val modelInstance = DeliveryReceipt()

        // to test the property `msisdn` - The number the message was sent to. Numbers are specified in E.164 format.
        should("test msisdn") {
            // uncomment below to test the property
            //modelInstance.msisdn shouldBe ("TODO")
        }

        // to test the property `to` - The SenderID you set in `from` in your request.
        should("test to") {
            // uncomment below to test the property
            //modelInstance.to shouldBe ("TODO")
        }

        // to test the property `networkCode` - The Mobile Country Code Mobile Network Code (MCCMNC) of the carrier this phone number is registered with.
        should("test networkCode") {
            // uncomment below to test the property
            //modelInstance.networkCode shouldBe ("TODO")
        }

        // to test the property `messageId` - The Vonage ID for this message.
        should("test messageId") {
            // uncomment below to test the property
            //modelInstance.messageId shouldBe ("TODO")
        }

        // to test the property `price` - The cost of the message
        should("test price") {
            // uncomment below to test the property
            //modelInstance.price shouldBe ("TODO")
        }

        // to test the property `status` - A code that explains where the message is in the delivery process.
        should("test status") {
            // uncomment below to test the property
            //modelInstance.status shouldBe ("TODO")
        }

        // to test the property `scts` - When the DLR was received from the carrier in the following format `YYMMDDHHMM`. For example, `2001011400` is at `2020-01-01 14:00`
        should("test scts") {
            // uncomment below to test the property
            //modelInstance.scts shouldBe ("TODO")
        }

        // to test the property `errCode` - The status of the request. Will be a non `0` value if there has been an error, or if the status is unknown. See the [Delivery Receipt documentation](/messaging/sms/guides/delivery-receipts#dlr-error-codes) for more details
        should("test errCode") {
            // uncomment below to test the property
            //modelInstance.errCode shouldBe ("TODO")
        }

        // to test the property `apiKey` - The API key that sent the SMS. This is useful when multiple accounts are sending webhooks to the same endpoint.
        should("test apiKey") {
            // uncomment below to test the property
            //modelInstance.apiKey shouldBe ("TODO")
        }

        // to test the property `messageTimestamp` - The time when Vonage started to push this Delivery Receipt to your webhook endpoint.
        should("test messageTimestamp") {
            // uncomment below to test the property
            //modelInstance.messageTimestamp shouldBe ("TODO")
        }

    }
}
