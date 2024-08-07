package algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);  // Recursively sort elements before partition
            quickSort(arr, pi+1, high); // Recursively sort elements after partition
        }
    }

    /**
     * The whole purpose of this method, is to first find the appropriate place for pivot,
     * with all no. below pivot placed on the left and the remaining numbers on the right.
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // Index of smaller element

        // Iterate from the first element to the last element with prt - j.
        for (int j = low; j < high; j++) {
            // Whenever the current number is lower than the pivot (Right most)
            if (arr[j] < pivot) {
                // Increment i, as i+1 is the next empty spot to place the arr[j],
                // which is < pivot.
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }
        // After the iteration, we can be certain that all number before `i` and `i` itself is lower
        // than the pivot, so the correct place for pivot is i+1.
        swap(arr, i+1, high);
        return i+1;
    }

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
