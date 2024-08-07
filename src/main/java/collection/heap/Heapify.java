package collection.heap;

import java.util.Arrays;

public class Heapify {

    private void swap (int[] arr, int srcIndex, int destIndex) {
        int temp = arr[srcIndex];
        arr[srcIndex] = arr[destIndex];
        arr[destIndex] = temp;
    }

    public void minHeapify(int[] A, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Only if left exist and smaller than current node.
        if (left < n && A[left] < A[smallest]) {
            smallest = left;
        }

        // Only if right exist and smaller than current node.
        if (right < n && A[right] < A[smallest]) {
            smallest = right;
        }

        // If either left || right is smaller than the current node
        if (smallest != i) {
            // smallest is right, and i is parent
            swap(A, i, smallest);
            // Recursively heapify the affected sub-tree
            System.out.println(Arrays.toString(A));
            System.out.println("Recursive call with: " + smallest);
            minHeapify(A, n, smallest);
        }
    }

    public void buildMinHeap(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("Heapifing with index: " + i);
            minHeapify(A, n, i);
        }
    }

    public void maxHeapify(int[] A, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && A[left] > A[largest]) {
            largest = left;
        }

        if (right < n && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(A, i, largest);
            // Recursively heapify the affected sub-tree
            maxHeapify(A, n, largest);
        }
    }

    public void buildMaxHeap(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(A, n, i);
        }
    }
}