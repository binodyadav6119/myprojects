# Shopify POC

This project is a proof of concept (POC) to demonstrate the integration of a Shopify store with a Spring Boot application. The project covers the creation of webhooks, handling orders and fulfillments, and syncing data with Elasticsearch.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Creating Webhooks](#creating-webhooks)
- [Handling Fulfillments](#handling-fulfillments)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17** or later
- **Maven** (for building the project)
- **Spring Boot** (used in the application)
- **Elasticsearch 8.14.2**
- **ngrok** (for exposing your local server to the web)
- **Git** (for version control)

## Elastic Search Installation
- **Used Docker for ELastic search** 


   ```bash
   docker pull docker.elastic.co/elasticsearch/elasticsearch:8.14.2
   
   docker run -d --name elasticsearch \
-p 9200:9200 \
-e "discovery.type=single-node" \
-e "xpack.security.enabled=false" \
-e "ES_JAVA_OPTS=-Xms2g -Xmx2g" \
docker.elastic.co/elasticsearch/elasticsearch:8.14.2

```
## ngrok setup

**To sync order and fulfillment data**
- **whenever order is created in shopify we will receieve that particular order data via webhook exposed to creating the order**
</br>
- **Processing of configuring ngrok**
   ```bash
   sudo snap install ngrok
  ngrok config add-authtoken YOUR_AUTHTOKEN
   ngrok http 8085(springboot exposed port)
  ```

## Webhook Url Creation For Order data
- **Webhook url creation for creating order**
- **adress in payload is ngrok base url of spring app and endpoint is the controller where we want to recieve the order data**

   ```bash
   curl --location 'https://6a2e45-42.myshopify.com/admin/api/2023-07/webhooks.json' \
   --header 'Content-Type: application/json' \
   --header 'X-Shopify-Access-Token: <token>' \
   --data '{
     "webhook": {
       "topic": "orders/create",
       "address": "https://a420-2406-7400-63-93f2-7711-eea6-b4ce-b02f.ngrok-free.app/webhook/orders/create",
       "format": "json"
     }
   }'

  ```

## Webhook Url Creation For FulFillment data
- **Webhook url creation for creating fulfillment**
- **adress in payload is ngrok base url of spring app and endpoint is the controller where we want to recieve the fulfillment data**

   ```bash
   curl --location 'https://6a2e45-42.myshopify.com/admin/api/2023-07/webhooks.json' \
   --header 'Content-Type: application/json' \
   --header 'X-Shopify-Access-Token: <token>' \
   --data '{
   "webhook": {
   "topic": "fulfillments/create",
   "address": "https://a420-2406-7400-63-93f2-7711-eea6-b4ce-b02f.ngrok-free.app/webhook/fulfillment/create",
   "format": "json"
   }
   }'

  ```