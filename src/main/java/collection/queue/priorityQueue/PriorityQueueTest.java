package collection.queue.priorityQueue;


import java.util.PriorityQueue;

/**
 * Unlike normal Queue, element will be inserted into
 * appropriate pose, by calling the comparator method.
 */
public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(1);
        pq.offer(4);
        pq.offer(9);
        pq.offer(0);

        System.out.println("Print PQ content: ");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }



    }
}
