public class Item {
     int n;
     int flag=0;
    synchronized public  void produce_item(int n) throws InterruptedException {
        if(flag==1)
        {
            wait();
        }
        this.n=n;
        System.out.println("produced item->"+this.n);
        flag=1;
        notify();
    }
   synchronized public void consume_item() throws InterruptedException {
        if(flag==0)
        {
            wait();
        }
        System.out.println("consumed item->"+n);
        flag=0;
        notify();
    }
}
