package other;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPlayground {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(100, 500, 300);
        Optional<String> optionalString = Optional.of("Test");

        // Any match
        System.out.println(list.stream().anyMatch( a -> a == 100));

        // Stream to list
        System.out.println(list.stream().collect(Collectors.toList()));


        // Exception handling, but this provides no content for bug trace.
        optionalString.orElseThrow(RuntimeException::new);


        // Print the element out if existed.
        optionalString.ifPresent(System.out::println);
        System.out.println(optionalString.orElse("123"));


        // Handle duplicate item on list when convert to map.
        System.out.println(list.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        e -> 1,
                        Integer::sum)));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum); // 15
        System.out.println(sum);

        // Remove duplicate on a list.
        List<Integer> numbersList = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbersList.stream()
                .distinct().toList();
        System.out.println(distinctNumbers);

        // Print each element as the stream flow.
        numbersList.stream()
                .peek(System.out::print)
                .toList();

        System.out.println(numbersList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(". ", "[", "]")));

        // Collecting and then, to have an immutable list.
        List<String> unmodifiableList = Arrays.asList("1", "2", "3").stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        // even Numbers for size of 10.
        List<Integer> evenNumbers = Stream.iterate(0, n -> n + 2)
                .limit(10)
                .collect(Collectors.toList());


        Stream<String> stream1 = Stream.of("apple", "banana");
        Stream<String> stream2 = Stream.of("cherry", "date");
        Stream<String> combinedStream = Stream.concat(stream1, stream2);
        combinedStream.forEach(System.out::println);


        // takeWhile will stop when the current element don't fulfill the condition.
        List<Integer> numbersNine = Arrays.asList(1, 2, 99, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> taken = numbersNine.stream()
                .takeWhile(n -> n < 5)
                .collect(Collectors.toList()); // [1, 2], stopped at 99.
        System.out.println(taken);

        // Using filter
        List<Integer> filtered = numbersNine.stream()
                .filter(n -> n < 5)
                .collect(Collectors.toList()); // [1, 2, 3, 4]
        System.out.println(filtered);


        Map<Boolean, List<Integer>> partitioned = numbersNine.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));


        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length)); // {5=[apple], 6=[banana, cherry], 4=[date]}

        // Combining with other collectors
        Map<Integer, Long> countByLength = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting())); // {5=1, 6=2, 4=1}

        System.out.println(countByLength);

    }
}
