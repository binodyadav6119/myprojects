package com.binod.notification.channel;

import com.binod.notification.model.Notification;

public class SmsChannel implements NotificationChannel {

    @Override
    public boolean send(Notification notification) {
        System.out.println("[SMS] Sending sms to: "
                + notification.getRecipient());
        System.out.println("[SMS] Message: "
                + notification.getMessage());
        return true;
    }
}