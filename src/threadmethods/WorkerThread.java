package threadmethods;

// A worker thread that demonstrates basic thread methods
public class WorkerThread extends Thread {

    @Override
    public void run() {
        // The logic executed by the thread when it starts
        System.out.println(getName() + " is running.");

        try {
            // Pause the thread for 2 seconds
            Thread.sleep(2000);
            System.out.println(getName() + " woke up after sleeping.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted during sleep.");
        }
    }
}
