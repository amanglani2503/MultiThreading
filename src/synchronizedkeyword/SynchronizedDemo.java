package synchronizedkeyword;

public class SynchronizedDemo {
    public static void main(String[] args) {
        // Create a single Counter object shared by multiple threads
        Counter counter = new Counter();

        // Create two threads that share the same Counter object
        CounterThread thread1 = new CounterThread(counter);
        thread1.setName("Thread-1");

        CounterThread thread2 = new CounterThread(counter);
        thread2.setName("Thread-2");

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Print the final counter value
        System.out.println("Final counter value: " + counter.getCount());
    }
}
