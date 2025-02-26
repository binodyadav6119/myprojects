package OBSERVABLE;

import OBSERVER.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements  StocksObservable{

    List<NotificationObserver> list= new ArrayList<>();
    int stockCount;
    @Override
    public void add(NotificationObserver observer) {
        list.add(observer);

    }

    @Override
    public void remove(NotificationObserver observer) {
        list.remove(observer);

    }

    @Override
    public void notifySubscriber() {
        for(NotificationObserver notificationObserver: list)
        {
            notificationObserver.update();
        }

    }

    @Override
    public int setStock(int stock) {
        notifySubscriber();
        stockCount=stock;
        return 0;
    }

    @Override
    public int getCount() {
        return stockCount;
    }
}
