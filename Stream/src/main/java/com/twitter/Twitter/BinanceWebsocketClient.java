package com.twitter.Twitter;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import jakarta.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class BinanceWebsocketClient {

    private final String BINANCE_WEBSOCKET_URL = "wss://stream.binance.com:9443/ws/btcusdt@trade";
    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

    public BlockingQueue<String> getMessageQueue() {
        return messageQueue;
    }

    @PostConstruct
    public void connectToBinanceWebSocket() {
        WebSocketClient webSocketClient = new StandardWebSocketClient();

        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(
                webSocketClient,
                new BinanceWebSocketHandler(),
                BINANCE_WEBSOCKET_URL
        );

        connectionManager.start();
    }

    private class BinanceWebSocketHandler implements WebSocketHandler {

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("Connected to Binance WebSocket");
        }

        @Override
        public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
            String payload = message.getPayload().toString();
            System.out.println("Received: " + payload);

            // Store the message in the queue
            messageQueue.offer(payload);
        }

        @Override
        public void handleTransportError(WebSocketSession session, Throwable exception) {
            System.err.println("Error in WebSocket: " + exception.getMessage());
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
            System.out.println("WebSocket connection closed: " + status);
        }

        @Override
        public boolean supportsPartialMessages() {
            return false;
        }
    }
}
