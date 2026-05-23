package com.binod.notification.service;

import com.binod.notification.channel.NotificationChannel;
import com.binod.notification.model.Notification;

import java.util.HashMap;
import java.util.Map;

public class NotificationDispatcher {

    private final Map<String, NotificationChannel> channelRegistry
            = new HashMap<>();

    public void registerChannel(String channelName,
                                NotificationChannel notificationChannel) {
        channelRegistry.put(channelName.toUpperCase(),
                notificationChannel);
    }

    public void dispatch(Notification notification) {

        NotificationChannel channel = channelRegistry.get(
                notification.getChannel().toUpperCase()
        );

        if (channel == null) {
            throw new IllegalArgumentException(
                    "No channel found for: "
                            + notification.getChannel()
            );
        }

        int retryCount = notification
                .getRetryStrategy()
                .getRetryCount();

        int attempts = 0;
        boolean success = false;

        while (attempts <= retryCount && !success) {
            attempts++;
            System.out.println("\nAttempt: " + attempts);

            success = channel.send(notification);

            if (!success) {
                System.out.println("Retrying...");
            }
        }

        if (success) {
            System.out.println("Notification delivered successfully.");
        } else {
            System.out.println("Notification delivery failed.");
        }
    }
}