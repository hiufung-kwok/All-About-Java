package collection.queue.blockingQueue.type;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Similar to blocking queue with capacity == 1.
 */
public class SyncBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue bq = new SynchronousQueue();

        SampleProducer pd = new SampleProducer(bq);
        SampleConsumer cs = new SampleConsumer(bq);

        new Thread(pd).start();
        new Thread(cs).start();

        Thread.sleep(Duration.ofMinutes(3));

    }
}
