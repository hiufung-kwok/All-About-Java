package concurrent.basic.waitNotify;

public class WaitNotifyExample {
    private static final Object lock = new Object();
    private static volatile boolean condition = false;

    public static void main(String[] args) {
        // Thread A: waits until condition is true
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                while (!condition) {
                    try {
                        System.out.println("Thread A is waiting...");
                        lock.wait(); // Wait until condition is true
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread A woke up and condition is true");
            }
        });

        // Thread B: sets the condition to true and notifies waiting threads
        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                // Simulate some processing
                try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Set the condition to true
                condition = true;
                System.out.println("Thread B sets the condition to true and notifies waiting threads");
                lock.notify(); // Notify waiting threads
            }
        });

        // Start threads
        threadA.start();
        threadB.start();
    }
}