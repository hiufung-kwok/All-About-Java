package collection.queue.blockingQueue.type;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class SampleConsumer implements Runnable{

    // Keep a copy of an Abstract blocking queue instance.
    private BlockingQueue queue = null;

    public SampleConsumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i=0 ; i<1000 ; i++) {
                int workload = (int) queue.take();
                Thread.sleep(workload);
                System.out.println("Processed workload: " + workload);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
