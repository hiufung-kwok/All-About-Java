package collection.queue.blockingQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

class Producer implements Runnable {
    private final TransferQueue<String> transferQueue;

    public Producer(TransferQueue<String> transferQueue) {
        this.transferQueue = transferQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String task = generateTask();
                System.out.println("Producer produced task: " + task);
                // Transfer the task to a consumer, waiting if necessary
                transferQueue.transfer(task);
                Thread.sleep(1000); // Simulate some work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String generateTask() {
        return "Task-" + System.currentTimeMillis();
    }
}

class Consumer implements Runnable {
    private final TransferQueue<String> transferQueue;

    public Consumer(TransferQueue<String> transferQueue) {
        this.transferQueue = transferQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Receive a task from a producer, waiting if necessary
                String task = transferQueue.take();
                System.out.println("Consumer received task: " + task);
                // Process the task
                processTask(task);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void processTask(String task) {
        // Simulate processing of the task
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class TransferQueueExample {
    public static void main(String[] args) {
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();

        // Create and start producer and consumer threads
        Thread producerThread = new Thread(new Producer(transferQueue));
        Thread consumerThread = new Thread(new Consumer(transferQueue));
        producerThread.start();
        consumerThread.start();
    }
}
