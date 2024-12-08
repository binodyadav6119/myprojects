package com.twitter.Twitter.controller;



import com.twitter.Twitter.BinanceWebsocketClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingQueue;

@RestController
public class WebSocketDataController {

    private final BinanceWebsocketClient binanceWebSocketClient;

    public WebSocketDataController(BinanceWebsocketClient binanceWebSocketClient) {
        this.binanceWebSocketClient = binanceWebSocketClient;
    }

    @GetMapping("/latest")
    public String getLatestData() {
        BlockingQueue<String> messageQueue = binanceWebSocketClient.getMessageQueue();
        String latestMessage = messageQueue.poll(); // Get and remove the latest message
        return latestMessage != null ? latestMessage : "No data available";
    }
}

