package com.lang.enumTest;

import com.bookref.effectiveJava.enumAndAnnotations.simpleUsage;

import java.util.Arrays;

public class EnumTest {

    enum Weekday {
        Mon,
        Tue,
        Wed,
        Thu,
        Fri;

        // Enum can have methods.
        public boolean isOdd(Weekday day) {
            return (day == Mon || day == Wed || day == Fri);
        }
    }

    public static void main(String[] args) {
        System.out.println(Weekday.valueOf("Mon"));

        // Prepare for invalid option, when parsing enum.
        try {
            System.out.println(Weekday.valueOf("Test"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // Enum can be null.
        Weekday nullDay = null;

        // Enum can be iterated.
        Arrays.stream(Weekday.values()).forEach(System.out::println);


    }
}
