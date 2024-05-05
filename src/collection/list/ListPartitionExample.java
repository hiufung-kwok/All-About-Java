package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListPartitionExample {
    public static void main(String[] args) {
        // Create a sample list of integers
        List<Integer> originalList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            originalList.add(i);
        }

        // Define the size of each partition
        int partitionSize = 3;

        // Partition the list
        List<List<Integer>> partitionedList = partition(originalList, partitionSize);

        // Print each partition
        for (List<Integer> partition : partitionedList) {
            System.out.println(partition);
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int partitionSize) {
        List<List<T>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += partitionSize) {
            int end = Math.min(i + partitionSize, list.size());
            partitions.add(list.subList(i, end));
        }
        return partitions;
    }
}

