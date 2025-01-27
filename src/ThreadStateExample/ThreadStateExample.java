package ThreadStateExample;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread state in run(): " + Thread.currentThread().getState());
        try {
            Thread.sleep(2000); // Timed Waiting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadStateExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        System.out.println("State after creation: " + thread.getState()); // NEW

        thread.start();
        System.out.println("State after start(): " + thread.getState()); // RUNNABLE

        try {
            Thread.sleep(500); // Allow thread to start running
            System.out.println("State during execution: " + thread.getState()); // RUNNABLE or TIMED_WAITING
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after completion: " + thread.getState()); // TERMINATED
    }
}
