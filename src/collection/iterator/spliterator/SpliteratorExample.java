package collection.iterator.spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        // Get a spliterator from the list
        Spliterator<Integer> spliterator = numbers.spliterator();

        // Split the task into smaller tasks
        Spliterator<Integer> evenNumbersSpliterator = spliterator.trySplit();

        // Use parallel processing to find the sum of even numbers
        int sumOfEvenNumbers = evenNumbersSpliterator
                .tryAdvance(System.out::println) // Print each element (just for demonstration)
                ? numbers.stream()              // If there are elements, create a stream from the numbers
                .filter(n -> n % 2 == 0) // Filter out even numbers
                .mapToInt(Integer::intValue) // Map to int values
                .sum()                      // Sum the integers
                : 0;                                // If no elements, return 0

        System.out.println("Sum of even numbers: " + sumOfEvenNumbers);
    }
}
