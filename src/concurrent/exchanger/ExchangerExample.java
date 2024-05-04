package concurrent.exchanger;

import java.util.concurrent.Exchanger;

class Producer implements Runnable {
    private Exchanger<String> exchanger;
    private String data;

    public Producer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        this.data = "Initial Data";
    }

    @Override
    public void run() {
        try {
            // Simulate producing data
            Thread.sleep(2000);
            // Exchange data with the consumer thread
            System.out.println("Producer is ready to exchange data.");
            data = exchanger.exchange(data);
            System.out.println("Producer received: " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private Exchanger<String> exchanger;

    public Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            // Simulate processing received data
            Thread.sleep(1000);
            // Exchange data with the producer thread
            System.out.println("Consumer is ready to exchange data.");
            String receivedData = exchanger.exchange("New Data from Consumer");
            System.out.println("Consumer received: " + receivedData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        // Create producer and consumer threads
        Producer producer = new Producer(exchanger);
        Consumer consumer = new Consumer(exchanger);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Start the threads
        producerThread.start();
        consumerThread.start();
    }
}
