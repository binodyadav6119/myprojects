package com.binod.notification;

import com.binod.notification.channel.*;
import com.binod.notification.factory.NotificationChannelFactory;
import com.binod.notification.model.Notification;
import com.binod.notification.model.NotificationType;
import com.binod.notification.service.NotificationDispatcher;
import com.binod.notification.strategy.HighPriorityRetryStrategy;
import com.binod.notification.strategy.NoRetryStrategy;

public class Main {
    public static void main(String[] args) {

        NotificationDispatcher dispatcher = new NotificationDispatcher();

        dispatcher.registerChannel("EMAIL",
                NotificationChannelFactory.createChannel("EMAIL"));
        dispatcher.registerChannel("SMS",
                NotificationChannelFactory.createChannel("SMS"));
        dispatcher.registerChannel("PUSH",
                NotificationChannelFactory.createChannel("PUSH"));

        Notification orderNotification = new Notification(
                "Your order #1234 has been shipped",
                "binod@example.com",
                NotificationType.TRANSACTIONAL,
                "EMAIL",
                new HighPriorityRetryStrategy()
        );

        Notification otpNotification = new Notification(
                "OTP is 4590",
                "+919999999999",
                NotificationType.CRITICAL,
                "SMS",
                new NoRetryStrategy()
        );

        Notification promoNotification = new Notification(
                "Flat 50% OFF on all products",
                "mobile-device-token",
                NotificationType.PROMOTIONAL,
                "PUSH",
                new HighPriorityRetryStrategy()
        );

        dispatcher.dispatch(orderNotification);
        dispatcher.dispatch(otpNotification);
        dispatcher.dispatch(promoNotification);
    }
}