package com.lang.intTest;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class IntTest {

    public static void main(String[] args) {

//
//        methodTester(Integer::numberOfTrailingZeros);
//        methodTester(Integer::numberOfLeadingZeros);


        // Overflow test.
        int a = Integer.MAX_VALUE;
        int b = 1;

        try {
            int result = Math.addExact(a, b);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Overflow occurred: " + e.getMessage());
        }

        System.out.println(a + 1);

        System.out.println(Integer.reverseBytes(8));
        System.out.println(Integer.toUnsignedLong(8));

    }


    private static void methodTester (UnaryOperator<Integer> expression) {
        Stream.of(1, 2, 4, 8, 16, 32)
                .map(expression)
                .forEach(System.out::println);

    }

}
