package com.binod.notification.channel;

import com.binod.notification.model.Notification;

public class EmailChannel implements NotificationChannel {

    @Override
    public boolean send(Notification notification) {
        System.out.println("[EMAIL] Sending email to: "
                + notification.getRecipient());
        System.out.println("[EMAIL] Message: "
                + notification.getMessage());
        return true;
    }
}