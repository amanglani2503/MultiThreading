package synchronizedkeyword;

// A shared resource class with synchronized methods
public class Counter {
    private int count = 0;

    // Synchronized method to increment the counter
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
    }

    // Getter for count
    public synchronized int getCount() {
        return count;
    }
}
