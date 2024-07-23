import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    private final Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void contemplate(int philosopher) throws InterruptedException {
        System.out.println("Philosopher " + philosopher + " is contemplating.");
        Thread.sleep((int) (Math.random() * 100));
    }

    public void eat(int philosopher) throws InterruptedException {
        System.out.println("Philosopher " + philosopher + " is eating.");
        Thread.sleep((int) (Math.random() * 100));
    }

    public void pickUpForks(int philosopher) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Pick up the lower-numbered fork first to avoid circular wait
        if (leftFork < rightFork) {
            forks[leftFork].acquire();
            forks[rightFork].acquire();
        } else {
            forks[rightFork].acquire();
            forks[leftFork].acquire();
        }
    }

    public void putDownForks(int philosopher) {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        forks[leftFork].release();
        forks[rightFork].release();
    }

    public void philosopher(int philosopher) throws InterruptedException {
        while (true) {
            contemplate(philosopher);
            pickUpForks(philosopher);
            eat(philosopher);
            putDownForks(philosopher);
        }
    }

    public static void main(String[] args) {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        Thread[] philosophers = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int philosopher = i;
            philosophers[i] = new Thread(() -> {
                try {
                    diningPhilosophers.philosopher(philosopher);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            philosophers[i].start();
        }
    }
}
