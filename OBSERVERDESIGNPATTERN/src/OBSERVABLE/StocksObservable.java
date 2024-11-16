package OBSERVABLE;

import OBSERVER.NotificationObserver;

public interface StocksObservable {

    public void add(NotificationObserver observer);
    public void remove(NotificationObserver observer);
    public void notifySubscriber();
    public int setStock(int stock);
    public int getCount();

}
