package com.shopify.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopify.demo.indexes.Fulfillment;
import com.shopify.demo.service.FulfillmentService;
import com.shopify.demo.indexes.Order;
import com.shopify.demo.service.OrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class ShopifyWebhookController {

    @Autowired
    OrderService orderService;

    @Autowired
    FulfillmentService fulfillmentService;

    @PostMapping("/webhook/orders/create")
    public void handleOrderCreate(@RequestBody String payload,
                                  @RequestHeader("X-Shopify-Hmac-Sha256") String hmacHeader) throws JsonProcessingException {
        // Verify the HMAC signature here (to ensure the request is from Shopify)

        // Process the order creation event
        System.out.println("Order creation event received: " + payload);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(payload, Map.class);
        // Access the "customer" object
//        Map<String, Object> customerMap = (Map<String, Object>) jsonMap.get("customer");
//
//        if (customerMap != null) {
//            // Remove the "tax_exemptions" key from the "customer" object
//            customerMap.remove("tax_exemptions");
//            customerMap.remove("email_marketing_consent");
//            customerMap.remove("sms_marketing_consent");
//        }
//        jsonMap.remove("line_items");
//        jsonMap.remove("admin_graphql_api_id");
//        jsonMap.remove("checkout_id");
//        jsonMap.remove("current_subtotal_price_set");
//        jsonMap.remove("current_total_discounts_set");
//        jsonMap.remove("current_total_price_set");
//        jsonMap.remove("current_total_tax_set");

//        jsonMap.remove("subtotal_price_set");
//        jsonMap.remove("total_discounts_set");
//        jsonMap.remove("total_line_items_price_set");
//        jsonMap.remove("total_price_set");
//        jsonMap.remove("total_shipping_price_set");
//        jsonMap.remove("total_tax_set");
//        jsonMap.remove("device_id");
//        jsonMap.remove("landing_site_ref");
//        jsonMap.remove("reference");
//        jsonMap.remove("tax_exempt");
//        jsonMap.remove("total_shipping_price_set");
//        jsonMap.remove("total_shipping_price_set");
//        jsonMap.remove("total_shipping_price_set");
//        jsonMap.remove("total_shipping_price_set");
        String updatedJsonString = objectMapper.writeValueAsString(jsonMap);
        ObjectMapper objectMapper1 = new ObjectMapper();
        Order order = objectMapper1.readValue(updatedJsonString, Order.class);

        Mono<Order> order1 = orderService.saveOrder(order, "tenant2");
        order1.subscribe(
                savedOrder -> System.out.println("Order Details: " + savedOrder),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Order processing completed.")
        );
        System.out.println("order save is"+order1);
        // You can now persist the order data or trigger fulfillment processing
    }

    @PostMapping("/webhook/fulfillment/create")
    public void handleFulFillmentCreate(@RequestBody String payload,
                                  @RequestHeader("X-Shopify-Hmac-Sha256") String hmacHeader) throws JsonProcessingException {
        // Verify the HMAC signature here (to ensure the request is from Shopify)

        // Process the order creation event
        System.out.println("Fullfillment creation event received: " + payload);
        JSONObject jsonObject = new JSONObject(payload);

        // Check if the "status" key is present
        if (jsonObject.has("status")) {
            ObjectMapper objectMapper = new ObjectMapper();
            Fulfillment fulfillment = objectMapper.readValue(payload, Fulfillment.class);
            Mono<Fulfillment> fulfillment1 = fulfillmentService.saveFulfillment(fulfillment, "tenant2");

            fulfillment1.subscribe(
                    savedFulfillment -> System.out.println("Fulfillment Details: " + savedFulfillment),
                    error -> System.err.println("Error: " + error),
                    () -> System.out.println("Fulfillment processing completed.")
            );
        }

    }
}
