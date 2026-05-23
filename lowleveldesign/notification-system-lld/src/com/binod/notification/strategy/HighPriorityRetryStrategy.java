package com.binod.notification.strategy;

public class HighPriorityRetryStrategy implements RetryStrategy {

    @Override
    public int getRetryCount() {
        return 3;
    }
}