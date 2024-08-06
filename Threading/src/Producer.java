public class Producer extends Thread{

    Item item;
    Producer(Item item)
    {
        this.item=item;
    }

    public  void run()
    {
        int i=1;
        while(true)
        {
            try {
                this.item.produce_item(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
