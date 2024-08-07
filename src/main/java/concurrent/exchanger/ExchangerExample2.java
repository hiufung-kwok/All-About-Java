package concurrent.exchanger;

import java.util.concurrent.Exchanger;

class DataProducer implements Runnable {
    private Exchanger<Integer> exchanger;

    public DataProducer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            int data = 10;
            System.out.println("Producer is ready to exchange data.");
            // Exchange data with the consumer thread
            data = exchanger.exchange(data);
            System.out.println("Producer received: " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DataConsumer implements Runnable {
    private Exchanger<Integer> exchanger;

    public DataConsumer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            int receivedData = exchanger.exchange(0); // Initialize with default data
            System.out.println("Consumer is ready to exchange data.");
            // Process received data and send back modified data
            receivedData *= 2;
            receivedData = exchanger.exchange(receivedData);
            System.out.println("Consumer received: " + receivedData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExchangerExample2 {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        // Create producer and consumer threads
        DataProducer producer = new DataProducer(exchanger);
        DataConsumer consumer = new DataConsumer(exchanger);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Start the threads
        producerThread.start();
        consumerThread.start();
    }
}
