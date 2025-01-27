package unfairlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
    private final Lock unfairLock = new ReentrantLock(true);    // true makes locking fair

    public void accessResource() {
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the Lock !");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock !");
            unfairLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UnfairLockExample example = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread1");
        Thread thread2 = new Thread(task, "Thread2");
        Thread thread3 = new Thread(task, "Thread3");

        try{
            thread1.start();
            Thread.sleep(50);
            thread2.start();
            Thread.sleep(50);
            thread3.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/* Fairness of lock does not mean that the order in which you start the
thread, in same order threads will acquire the lock. It just means that
locks are acquired on the basis of their arrival */