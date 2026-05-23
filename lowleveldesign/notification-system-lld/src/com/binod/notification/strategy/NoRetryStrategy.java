package com.binod.notification.strategy;

public class NoRetryStrategy implements RetryStrategy {

    @Override
    public int getRetryCount() {
        return 0;
    }
}