package synchronizedkeyword;

public class CounterThread extends Thread {
    private final Counter counter;

    // Constructor to initialize the shared Counter object
    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Call the synchronized method to increment the counter
            counter.increment();
            try {
                Thread.sleep(100); // Simulate some delay
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
    }
}
