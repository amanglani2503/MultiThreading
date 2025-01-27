package threadmethods;

public class ThreadMethodsDemo {
    public static void main(String[] args) {
        // Create a thread object
        WorkerThread thread1 = new WorkerThread();

        // Set the name of the thread
        thread1.setName("Worker-1");

        // Print the thread name
        System.out.println("Thread name: " + thread1.getName());

        // Get and display the thread priority
        System.out.println("Default Priority: " + thread1.getPriority());

        // Set a custom priority for the thread
        thread1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Updated Priority: " + thread1.getPriority());

        // Start the thread (calls run() method on a separate call stack)
        thread1.start();

        // Check if the thread is alive
        System.out.println("Is " + thread1.getName() + " alive? " + thread1.isAlive());

        // Wait for the thread to complete
        try {
            thread1.join();
            System.out.println(thread1.getName() + " has finished execution.");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Create a daemon thread
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running in the background...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Daemon thread interrupted.");
                    break;
                }
            }
        });

        // Set the thread as a daemon
        daemonThread.setDaemon(true);
        daemonThread.start();

        // Yield the current thread to give other threads a chance
        Thread.yield();
        System.out.println("Main thread has yielded.");

        // Check the state of a thread
        System.out.println("Daemon thread state: " + daemonThread.getState());

        // Interrupt the daemon thread
        daemonThread.interrupt();
        System.out.println("Daemon thread was interrupted.");

        // Display the current thread
        System.out.println("Current thread: " + Thread.currentThread().getName());
    }
}
