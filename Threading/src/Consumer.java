public class Consumer extends Thread{

    Item item;
    Consumer(Item item)
    {
        this.item=item;
    }
    public void run()
    {
        while(true)
        {
            try {
                this.item.consume_item();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
