package collection.heap;

import java.util.Arrays;

public class HeapifyMain {

    public static void main(String[] args) {
        Heapify heapify = new Heapify();

        int[] maxHeapArray = {4, 10, 3, 5, 1, 55, 0, 80, 757};
        System.out.println("Max start: " + Arrays.toString(maxHeapArray));
        heapify.buildMaxHeap(maxHeapArray);
        System.out.println("Max-Heap: " + Arrays.toString(maxHeapArray));

        int[] minHeapArray = {4, 10, 3, 5, 1, 55, 0, 80, 757};
        System.out.println("Min start: " + Arrays.toString(minHeapArray));
        heapify.buildMinHeap(minHeapArray);
        System.out.println("Min-Heap: " + Arrays.toString(minHeapArray));
    }
}
