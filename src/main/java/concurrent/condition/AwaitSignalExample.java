package concurrent.condition;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignalExample {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void awaitMethod() {
        lock.lock();
        try {
            System.out.println("Thread waiting...");
            // It only works when the lock is locked.
            condition.await();  // Thread waits here
            System.out.println("Thread resumed after signal.");
        } catch (InterruptedException e) {
            System.out.println("Being Interrupted. ");
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void signalMethod() {
        lock.lock();
        try {
            System.out.println("Sending signal to waiting thread...");
            condition.signal();  // Signal the waiting thread
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AwaitSignalExample example = new AwaitSignalExample();

        Thread awaitThread = new Thread(example::awaitMethod);
        awaitThread.start();

        Thread.sleep(1000); // Ensure the await thread starts and waits

        example.signalMethod();
    }
}
