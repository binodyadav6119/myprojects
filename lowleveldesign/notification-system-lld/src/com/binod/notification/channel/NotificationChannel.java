package com.binod.notification.channel;

import com.binod.notification.model.Notification;

public interface NotificationChannel {
    boolean send(Notification notification);
}