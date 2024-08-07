package collection.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    // Create a ConcurrentHashMap with Integer keys and String values
    private static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    // Runnable task to add elements to the map concurrently
    private static class AddTask implements Runnable {
        private int key;
        private String value;

        public AddTask(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public void run() {
            // Add the key-value pair to the map
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " added: " + key + " -> " + value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create multiple threads to add elements concurrently
        Thread thread1 = new Thread(new AddTask(1, "Value1"));
        Thread thread2 = new Thread(new AddTask(2, "Value2"));
        Thread thread3 = new Thread(new AddTask(3, "Value3"));

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        thread1.join();
        thread2.join();
        thread3.join();

        // Print the final state of the map
        System.out.println("Final map: " + map);
    }
}
