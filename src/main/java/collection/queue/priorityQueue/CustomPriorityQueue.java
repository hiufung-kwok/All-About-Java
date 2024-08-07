package collection.queue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class CustomPriorityQueue {
    public static void main(String[] args) {
        Comparator<Integer> customComparator = (a, b) -> b - a; // Descending order

        PriorityQueue<Integer> pq = new PriorityQueue<>(customComparator);

        pq.add(5);
        pq.add(1);
        pq.add(10);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
