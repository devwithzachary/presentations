---
marp: true
header: 'Building a Kotlin Multiplatform Library in 10 Minutes. Why Not?'
footer: 'Zachary Powell - DevRel Manager At Vonage - @devwithzachary'
theme: default
class: invert
---

# Building a Kotlin Multiplatform Library in 10 Minutes. 
## Why Not?

---

* viewer discretion advised - live code generation ahead (Make image)

---

OpenAPI 
(NOT OPENAI)

---

Have you heard of OpenAPI?

---

Do you use OpenAPI?

---

What is OpenAPI

---

Why is it useful? as a contract internally/externally

---

JSON VS YAML (phycopaths)

---

Example

---

Code generator! (another warning)

---

Generate the code

```java -jar ../openapi-generator-cli.jar generate -i ../sms.json -g kotlin --additional-properties=library=multiplatform,dateLibrary=kotlinx-datetime```

---

Explore it

---

Run test application (send text to self)

---

Problems
 Incomplete OpenAPI spec
    * business logic
    * helper function
    * Checkout the kotlin SDK!

---

# Thank you!

![width:300px](images/me.png) 

![bg right:40% width:500px](images/qr.png)

links.zpweb.site

github.com/devwithzachary/presentations
