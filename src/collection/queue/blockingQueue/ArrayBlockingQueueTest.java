package collection.queue.blockingQueue;

import java.time.Duration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * TBC
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue bq = new ArrayBlockingQueue(100);

        SampleProducer pd = new SampleProducer(bq);
        SampleConsumer cs = new SampleConsumer(bq);

        new Thread(pd).start();
        new Thread(cs).start();

        Thread.sleep(Duration.ofMinutes(3));

    }
}
