
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
public class Concurrency {
    private int readers=0;
    private boolean isWriting=false;
    private final ReentrantLock lock= new ReentrantLock();
    private final Condition condition= lock.newCondition();

    public void acquireReadLock() throws InterruptedException {
        lock.lock();
        try{
            while(isWriting)
            {
                condition.await();
            }
            readers++;
        }
        finally {
            lock.unlock();
        }
    }
    public void releaseReadLock()
    {
        lock.lock();
        try{
            readers--;
            if(readers==0)
            {
                condition.signalAll();
            }
        }
        finally {
            lock.unlock();
        }
    }

    public void acquireWriteLock() throws InterruptedException {
        lock.lock();
        try{
            while(readers>0 || isWriting)
            {
                condition.await();
            }
            isWriting=true;
        }finally {
            lock.unlock();
        }
    }

    public void releaseWriteLock()
    {
        lock.lock();
        try{
            isWriting=false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Concurrency concurrency = new Concurrency();

        Runnable readerTask=new Runnable() {
            @Override
            public void run() {
                try{
                    concurrency.acquireReadLock();
                    System.out.println(Thread.currentThread().getName()+"is reading");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"finished reading");
                    concurrency.releaseReadLock();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable writerTask = new Runnable() {
            @Override
            public void run() {
                try{
                    concurrency.acquireWriteLock();
                    System.out.println(Thread.currentThread().getName()+"is writing");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"finished writing");
                    concurrency.releaseWriteLock();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread writer = new Thread(writerTask);
        Thread reader1= new Thread(readerTask);
        Thread reader2= new Thread(readerTask);

        reader1.start();
        reader2.start();
        writer.start();
    }
}
