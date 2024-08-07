package concurrent.lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock maintain an internal count to keep track of the lock,
 * which includes recursive locking.
 */
public class ReentrantLockExample {
    // Create a ReentrantLock
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Thread 1 acquires the lock
        Thread thread1 = new Thread(() -> {
            lock.lock();
            System.out.println("Thread 1 acquired the lock");

            // Nested lock attempt (reentrant)
            lock.lock();
            System.out.println("Thread 1 acquired the lock again");

            // Simulate some work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Release the lock
            lock.unlock();
            System.out.println("Thread 1 released the lock");

            // Release the lock again
            lock.unlock();
            System.out.println("Thread 1 released the lock again");
        });

        // Thread 2 attempts to acquire the lock
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Try to acquire the lock
            if (lock.tryLock()) {
                System.out.println("Thread 2 acquired the lock");
                lock.unlock();
                System.out.println("Thread 2 released the lock");
            } else {
                System.out.println("Thread 2 failed to acquire the lock");
            }
        });

        // Start threads
        thread1.start();
        thread2.start();
    }
}
