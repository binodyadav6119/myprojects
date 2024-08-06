import java.awt.*;

public class StaticThread {

    public synchronized static void wish(String name) throws InterruptedException {
        for(int i=0;i<3;i++)
        {
            System.out.println("Hello---->"+name);
            Thread.sleep(2000);
        }
    }
}

class MyThread extends Thread
{
    StaticThread staticThread;
    String name;
    MyThread(StaticThread staticThread,String name)
    {
        this.staticThread=staticThread;
        this.name=name;
    }
    public void run()
    {
        try {
            staticThread.wish(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MainTest
{
    public static void main(String[] args) {
        StaticThread staticThread = new StaticThread();
        StaticThread staticThread1 = new StaticThread();
        MyThread myThread = new MyThread(staticThread,"binod");
        MyThread myThread1 = new MyThread(staticThread,"yadav");
        myThread.start();
        myThread1.start();

    }
}
