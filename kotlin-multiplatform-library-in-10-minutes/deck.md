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

<!-- _backgroundColor: red -->

# <span style="color:white; font-size: 180px;">!! WARNING !!</span> 
## <span style="color:white; font-size: 40px;"> Viewer Discretion Advised - Live Code Generation Ahead</span> 

---

# Zachary Powell
## Android Developer Since 2009
## Sr Android Developer Advocate
## Manager, DevRel at Vonage
@DevWithZachary

![bg right:40% ](images/me.png) 

---

# Communication and Network APIs

![bg right:50% width:100%](images/VonagePOE.png) 

---

# Libraries Libraries Libraries

* Framework SDK's
* Testing
* Dependency Injector
* Networking
* Plus many many more.....

![bg right:40% ](images/library.png) 

---

# Application Programming Interfaces (APIs) 

* Third Party APIs 
* Internal APIs

![bg right:40% ](images/code.png) 

---

# Consuming APIs manually sucks!

* Lacking Libraries 
* Missing Documentation
* Time consuming
* Ambiguity

![bg right:40% width 100% ](images/code-handover.jpeg) 

---

# <span style="font-size: 140px;">Lets fix that with...</span>

---

# <span style="font-size: 120px;">Generating Libraries!</span>

---



![bg contain](images/openapi_light.png) 

---

![bg contain](images/openai_logo.png) 

---

![bg contain](images/openapi_light.png) 

---

# Have you heard of OpenAPI? 

![bg right:40% width 100% ](images/openapi_light.png) 

---

# Do you use OpenAPI?

![bg right:40% width 100% ](images/openapi_light.png) 

---

# What is OpenAPI?

![bg right:40% width 100% ](images/openapi_light.png) 

---

## What is OpenAPI?
"The OpenAPI Specification (OAS) defines a standard, language-agnostic interface to HTTP APIs which allows both humans and computers to discover and understand the capabilities of the service without access to source code, documentation, or through network traffic inspection." - https://swagger.io/specification/

---

## What is OpenAPI?

# OpenAPI Documents

![bg right:40% width 100% ](images/openapi_light.png) 

---

## OpenAPI Documents

# Define Objects that Break Down your API Definition

* Meta Data
* Server Infomation
* End points
* Parameters....

---

# JSON

```json
{
  "title": "Sample Pet Store App",
  "summary": "A pet store manager.",
  "termsOfService": "https://example.com/terms/",
  "contact": {
    "name": "API Support",
    "url": "https://www.example.com/support",
    "email": "support@example.com"
  },
  "license": {
    "name": "Apache 2.0",
    "url": "https://www.apache.org/licenses/LICENSE-2.0.html"
  },
  "version": "1.0.1"
}
```

---

# YAML

```yaml
title: Sample Pet Store App
summary: A pet store manager.
termsOfService: https://example.com/terms/
contact:
  name: API Support
  url: https://www.example.com/support
  email: support@example.com
license:
  name: Apache 2.0
  url: https://www.apache.org/licenses/LICENSE-2.0.html
version: 1.0.1
```

---

# But Why?

![bg right:40% width 100% ](images/why.jpg) 

---

## But Why?

# Define an API Contract between those building the API and those using it.

---

## But Why?
# The Tooling!

* Documentation
* Mocking
* Security
* Testing
* <b>Code Generation</b>
* openapi.tools

![bg right:50% width 100% ](images/tools.jpg) 

---

# Vonage SMS API

https://developer.vonage.com/en/api/sms

![bg right:40% width:100%](images/VonagePOE.png) 

---
```json
"paths": {
      "/{format}": {
         "post": {
            "operationId": "send-an-sms",
            "summary": "Send an SMS",
            "description": "Send an outbound SMS from your Vonage account",
            "parameters": [
               {
                  "name": "format",
                  "description": "The format of the response",
                  "in": "path",
                  "required": true,
                  "schema": {
                     "example": "json",
                     "type": "string",
                     "enum": [
                        "json",
                        "xml"
                     ],
                     "default": "json"
                  }
               }
            ], ...
```
---

# OpenAPI Generator

https://openapi-generator.tech/

![bg right:40% ](images/code.png) 

---

# Servers

<span style="font-size: 20px;">ada-server, aspnet-fastendpoints, aspnetcore, cpp-pistache-server, cpp-qt-qhttpengine-server, cpp-restbed-server, cpp-restbed-server-deprecated, csharp-functions, erlang-server,erlang-server-deprecated, fsharp-functions, fsharp-giraffe-server, go-echo-server, go-gin-server, go-server, graphql-nodejs-express-server, haskell, haskell-yesod, java-camel, java-helidon-server, java-inflector, java-micronaut-server, java-microprofile, java-msf4j, java-pkmst, java-play-framework, java-undertow-server, java-vertx, java-vertx-web, java-wiremock, jaxrs-cxf, jaxrs-cxf-cdi, jaxrs-cxf-extended, jaxrs-jersey, jaxrs-resteasy, jaxrs-resteasy-eap, jaxrs-spec, julia-server, kotlin-server, kotlin-spring, kotlin-vertx, kotlin-wiremock, nodejs-express-server, php-flight, php-laravel, php-lumen, php-mezzio-ph, php-slim4, php-symfony, python-aiohttp, python-blueplanet, python-fastapi, python-flask, ruby-on-rails, ruby-sinatra, rust-axum, rust-server, scala-akka-http-server, scala-cask, scala-finch, scala-http4s-server, scala-lagom-server, scala-play-server, scalatra, spring</span>


---

# Clients
ada, android, apex, bash, c, clojure, cpp-qt-client, cpp-restsdk, cpp-tiny, cpp-tizen,  cpp-ue4, crystal, csharp, dart, dart-dio, eiffel, elixir, elm, erlang-client, erlang-proper, go, groovy, haskell-http-client, java, javascript, jaxrs-cxf-client, jetbrains-http-client, jmeter, julia-client, k6, kotlin, lua, n4js, nim, objc, ocaml, perl, php, powershell, python, r, ruby, rust, scala, scalaz, swift-combine, swift5, typescript, xojo-client, zapier

---

# Clients
ada, android, apex, bash, c, clojure, cpp-qt-client, cpp-restsdk, cpp-tiny, cpp-tizen,  cpp-ue4, crystal, csharp, dart, dart-dio, eiffel, elixir, elm, erlang-client, erlang-proper, go, groovy, haskell-http-client, java, javascript, jaxrs-cxf-client, jetbrains-http-client, jmeter, julia-client, k6, <span style="color:white; font-size: 180px;">kotlin</span>, lua, n4js, nim, objc, ocaml, perl, php, powershell, python, r, ruby, rust, scala, scalaz, swift-combine, swift5, typescript, xojo-client, zapier

---

# Generate the code

java -jar ../openapi-generator-cli.jar generate 
-i ../sms.json 
-g kotlin 
--additional-properties=library=multiplatform,dateLibrary=kotlinx-datetime


---

# Generate the code

<span style="color:white; font-size: 50px;">java -jar ../openapi-generator-cli.jar generate</span>
-i ../sms.json 
-g kotlin 
--additional-properties=library=multiplatform,dateLibrary=kotlinx-datetime


---

# Generate the code

java -jar ../openapi-generator-cli.jar generate 
<span style="color:white; font-size: 50px;">-i ../sms.json </span>
-g kotlin 
--additional-properties=library=multiplatform,dateLibrary=kotlinx-datetime


---

# Generate the code

java -jar ../openapi-generator-cli.jar generate 
-i ../sms.json 
<span style="color:white; font-size: 50px;">-g kotlin </span>
--additional-properties=library=multiplatform,dateLibrary=kotlinx-datetime


---

# Generate the code

java -jar ../openapi-generator-cli.jar generate 
-i ../sms.json 
-g kotlin 
<span style="color:white; font-size: 50px;">--additional-properties=library=multiplatform,dateLibrary=kotlinx-datetime</span>


---

# Generate the code!

---

# Photo Break!

---

# Why Not?

![bg right:40% width 100% invert](images/why.jpg) 

---

## Why Not?

# Incomplete/Complex OpenAPI specs may not generate as expected

---

## Why Not?

# Purely one to one mapping

---

## Why Not?

# No additional business logic or helper functions

---

## Why Not?

# BUT its a great starting point!

---

# Hand made SDKs here to stay!

![bg right:40% ](images/handcraft.png)

---

# Checkout the new Kotlin Server SDK

Coupon Code, €10 free credit: <b>25DEVW10</b>

https://github.com/Vonage/vonage-kotlin-sdk

![bg right:40% width:500px](images/vonage-qr.png)

---

# Thank you!

![width:300px](images/me.png) 

![bg right:40% width:500px](images/qr.png)

links.zpweb.site

github.com/devwithzachary/presentations
