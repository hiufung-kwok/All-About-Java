package concurrent.lock.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * To demonstrate the practical use of the reentrant lock.
 * In the case that same thread make nested method call and
 * need to acquire the same lock for multiple time.
 */
public class ReentrantNestedLockExample {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            methodA();
        }).start();
    }

    public static void methodA() {
        lock.lock();
        System.out.println("Method A: Lock acquired");
        try {
            // Calling methodB, which also needs to acquire the same lock
            methodB();
        } finally {
            lock.unlock();
            System.out.println("Method A: Lock released");
        }
    }

    public static void methodB() {
        lock.lock(); // Reentrant lock acquisition
        System.out.println("Method B: Lock acquired");
        try {
            // Perform some operations
            System.out.println("Method B: Performing operations");
        } finally {
            lock.unlock();
            System.out.println("Method B: Lock released");
        }
    }
}

