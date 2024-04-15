package collection.queue.blockingQueue;

import org.junit.jupiter.api.MethodOrderer;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class SampleProducer implements Runnable{

    // Keep a copy of an Abstract blocking queue instance.
    private BlockingQueue queue = null;

    private Random random = new Random();


    public SampleProducer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i=0 ; i<1000 ; i++) {
                int workload = random.nextInt(1000);
                queue.put(workload);
                System.out.println("Inserted workload: " + workload);
                // Wait for the same time period until the next insert,
                // if it's not blocking.
                Thread.sleep(workload);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
