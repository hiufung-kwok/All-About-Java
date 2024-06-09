package com.lang.doubleTest;

import java.util.List;
import java.util.stream.Stream;

public class DoubleTest {

    public static void main(String[] args) {
        double test = 1.0 / 0.0;
        // It cast the infinite to the max number on Int.
        int testInt = (int) test;
        System.out.println(testInt);

        double test1 = 10;
        double test2 = 10;
        // It's true, because when both are primitive, it compares the actual value.
        System.out.println(test1 == test2);

        // It's true, because testObj1 being unboxing before the comparison.
        Double testObj1 = Double.valueOf(10);
        System.out.println(test1 == testObj1);

        // Nan
        double nanValue = 0.0 / 0.0;
        System.out.println(nanValue);

        // Same.
        try {
            Double.valueOf("not a number");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Double.parseDouble("not a number");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        // To make sure you have a valid double to proceed.
        Stream.of(
                1.0,
                Double.NaN,
                Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY
        )
            .map(Double::isFinite)
            .forEach(System.out::println);


    }
}
