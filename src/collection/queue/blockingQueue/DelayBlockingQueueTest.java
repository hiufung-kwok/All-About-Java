package collection.queue.blockingQueue;

import java.sql.SQLOutput;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * TBC
 */
public class DelayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue delayQueue = new DelayQueue();

        new Thread(() -> {
            delayQueue.offer(new SamplePayload("task1",10000));
            delayQueue.offer(new SamplePayload("task2",3900));
            delayQueue.offer(new SamplePayload("task3",1900));
            delayQueue.offer(new SamplePayload("task4",5900));
            delayQueue.offer(new SamplePayload("task5",6900));
            delayQueue.offer(new SamplePayload("task6",7900));
            delayQueue.offer(new SamplePayload("task7",4900));
            System.out.println("Insert completed");
        }).start();

        for (int i=0; i<7 ; i++) {
            Delayed take = (Delayed) delayQueue.take();
            System.out.println(take);
        }
    }
}
