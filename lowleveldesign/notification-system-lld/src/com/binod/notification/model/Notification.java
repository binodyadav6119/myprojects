package com.binod.notification.model;

import com.binod.notification.strategy.RetryStrategy;

public class Notification {

    private final String message;
    private final String recipient;
    private final NotificationType type;
    private final String channel;
    private final RetryStrategy retryStrategy;

    public Notification(String message,
                        String recipient,
                        NotificationType type,
                        String channel,
                        RetryStrategy retryStrategy) {
        this.message = message;
        this.recipient = recipient;
        this.type = type;
        this.channel = channel;
        this.retryStrategy = retryStrategy;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }

    public NotificationType getType() {
        return type;
    }

    public String getChannel() {
        return channel;
    }

    public RetryStrategy getRetryStrategy() {
        return retryStrategy;
    }
}