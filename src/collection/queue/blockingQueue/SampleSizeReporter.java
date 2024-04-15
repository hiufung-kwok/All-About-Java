package collection.queue.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class SampleSizeReporter implements Runnable{

    // Keep a copy of an Abstract blocking queue instance.
    private BlockingQueue queue = null;

    public SampleSizeReporter(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i=0 ; i<1000 ; i++) {
            System.out.println("Current Queue size: " + queue.size());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
