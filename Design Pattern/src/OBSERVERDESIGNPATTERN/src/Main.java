import OBSERVABLE.IphoneObservableImpl;
import OBSERVER.EmailAlertNotificationObserverImpl;
import OBSERVER.NotificationObserver;

public class Main {
    public static void main(String[] args) {


        IphoneObservableImpl iphoneObservable = new IphoneObservableImpl();

        NotificationObserver notificationObserver = new EmailAlertNotificationObserverImpl("test@gmail.com",iphoneObservable);
        notificationObserver.update();
        System.out.println("Hello world!");
    }
}