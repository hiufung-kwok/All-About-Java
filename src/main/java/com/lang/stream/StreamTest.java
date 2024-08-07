package com.lang.stream;

import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("D", "E", "F");

        Stream<String> combinedStream = Stream.concat(stream1, stream2);

        combinedStream.forEach(System.out::println);
    }
}
