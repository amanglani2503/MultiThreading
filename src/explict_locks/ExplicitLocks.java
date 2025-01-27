package explict_locks;
// Explicit locking

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 1000;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " trying to withdraw INR " + amount);
        try{
            if(lock.tryLock()){
                if(balance >= amount){
					try{
						System.out.println(Thread.currentThread().getName() + " proceeding with withdrawl !!");
						Thread.sleep(3000); // simulating transaction process
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " completed withdrawl");
					}
					catch(Exception e){
						Thread.currentThread().interrupt();
					}
					finally{
						lock.unlock();
					}
				}
                else{
                    System.out.println(Thread.currentThread().getName() + " Insufficient balance");
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " couldn't acquire lock");
            }
        }catch(Exception e){
			Thread.currentThread().interrupt();		// this is a good practice. explainition in word file
        }finally{
            lock.unlock();
        }
    }
}

public class ExplicitLocks{
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(400);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
