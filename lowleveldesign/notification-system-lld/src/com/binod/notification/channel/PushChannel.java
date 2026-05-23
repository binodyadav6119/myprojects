package com.binod.notification.channel;

import com.binod.notification.model.Notification;

public class PushChannel implements NotificationChannel {

    @Override
    public boolean send(Notification notification) {
        System.out.println("[PUSH] Sending push notification to device: "
                + notification.getRecipient());
        System.out.println("[PUSH] Message: "
                + notification.getMessage());
        return true;
    }
}