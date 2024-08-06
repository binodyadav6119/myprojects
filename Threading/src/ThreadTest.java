public class ThreadTest extends Thread{


    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("prinitng val"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.println("testing thread in java");
    }

    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        threadTest.start();


    }
}

class ThreadRunnable implements Runnable
{

    public static void main(String[] args) {
        ThreadRunnable threadRunnable = new ThreadRunnable();
        Thread thread = new Thread(threadRunnable);
        ThreadTest threadTest = new ThreadTest();
        thread.start();
        threadTest.start();

    }

    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            System.out.println("another thread "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.println("inside run method");
    }
}
