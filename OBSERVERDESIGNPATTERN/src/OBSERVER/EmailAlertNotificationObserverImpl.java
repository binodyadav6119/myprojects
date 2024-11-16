package OBSERVER;

import OBSERVABLE.StocksObservable;

public class EmailAlertNotificationObserverImpl implements NotificationObserver{

    StocksObservable stocksObservable;
    String emailId;
    public EmailAlertNotificationObserverImpl(String emailId1, StocksObservable stocksObservable1)
    {
        emailId1=emailId;
        stocksObservable1=stocksObservable;
    }

    @Override
    public void update() {
        System.out.println("hurry up stocks is there");

    }
}
