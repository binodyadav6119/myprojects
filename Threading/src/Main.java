public class Main {
    public static void main(String[] args) {


        Item item = new Item();
        Producer producer = new Producer(item);
        Consumer consumer= new Consumer(item);
        producer.start();
        consumer.start();

        System.out.println("Hello world!");
    }
}