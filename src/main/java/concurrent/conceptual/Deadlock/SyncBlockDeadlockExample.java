package concurrent.conceptual.Deadlock;

/**
 * Deadlock can be prevented when all threads obtain locks in the same order.
 */
public class SyncBlockDeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        // Thread 1: Acquires lock1, then tries to acquire lock2
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1");
                try {
                    Thread.sleep(100); // Introduce delay to increase chance of deadlock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2");
                }
            }
        });

        // Thread 2: Acquires lock2, then tries to acquire lock1
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock2");
                try {
                    Thread.sleep(100); // Introduce delay to increase chance of deadlock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1");
                }
            }
        });

        // Start threads
        thread1.start();
        thread2.start();
    }
}