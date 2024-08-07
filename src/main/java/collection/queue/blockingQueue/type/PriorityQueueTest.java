package collection.queue.blockingQueue.type;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * To have producer insert in 100x, to demonstrate indeed element is being pulled by priority.
 */
public class PriorityQueueTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue bq = new PriorityBlockingQueue();

        SampleProducer pd = new SampleProducer(bq, 100, true);
        SampleConsumer cs = new SampleConsumer(bq);
        SampleSizeReporter sr = new SampleSizeReporter(bq);

        new Thread(pd).start();
        new Thread(cs).start();
        new Thread(sr).start();

        Thread.sleep(Duration.ofMinutes(3));

    }
}
