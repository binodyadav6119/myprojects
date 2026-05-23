package com.binod.notification.factory;

import com.binod.notification.channel.*;

public class NotificationChannelFactory {

    public static NotificationChannel createChannel(String type) {

        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailChannel();

            case "SMS":
                return new SmsChannel();

            case "PUSH":
                return new PushChannel();

            default:
                throw new IllegalArgumentException(
                        "Unsupported notification channel: " + type
                );
        }
    }
}