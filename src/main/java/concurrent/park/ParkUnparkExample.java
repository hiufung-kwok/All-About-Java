package concurrent.park;

import java.util.concurrent.locks.LockSupport;

public class ParkUnparkExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Child thread is parking...");
            LockSupport.park(); // Park the child thread
            System.out.println("Child thread is unparked!");
        });

        thread.start();

        // Sleep for some time to ensure the child thread starts parking
        Thread.sleep(2000);

        // Unpark the child thread after 2 seconds
        LockSupport.unpark(thread);
    }
}
