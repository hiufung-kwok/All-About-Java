package collection.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class heapTest {

    public static void main(String[] args) {
        // Max heap
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // Min heap
        Queue<Integer> minHeap = new PriorityQueue<>();
    }
}
