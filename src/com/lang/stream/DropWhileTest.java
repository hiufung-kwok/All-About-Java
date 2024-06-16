package com.lang.stream;

import java.util.List;
import java.util.stream.Collectors;

public class DropWhileTest {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> dropped = numbers.stream()
                .dropWhile(n -> n <= 5)
                .toList();

        System.out.println("Dropped: " + dropped); // Output: [6, 7, 8, 9, 10]
    }
}
