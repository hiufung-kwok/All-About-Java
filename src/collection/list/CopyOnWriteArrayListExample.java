package collection.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    // Create a CopyOnWriteArrayList
    private static List<Integer> list = new CopyOnWriteArrayList<>();

    // Runnable task to add elements to the list concurrently
    private static class AddTask implements Runnable {
        private int value;

        public AddTask(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            // Add the value to the list
            list.add(value);
            System.out.println(Thread.currentThread().getName() + " added: " + value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create multiple threads to add elements concurrently
        Thread thread1 = new Thread(new AddTask(1));
        Thread thread2 = new Thread(new AddTask(2));
        Thread thread3 = new Thread(new AddTask(3));

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        thread1.join();
        thread2.join();
        thread3.join();

        // Print the final state of the list
        System.out.println("Final list: " + list);
    }
}
