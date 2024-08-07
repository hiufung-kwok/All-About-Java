package com.lang.math;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;

public class RoundNumber {

    private static double THREE_INT = 3;
    private static double THREE_ONE = 3.1;
    private static double THREE_FIVE = 3.5;
    private static double THREE_SEVEN = 3.7;

    public static void main(String[] args) {

        printNumbers("Round", Math::round);
        printNumbers("Floor", Math::floor);
        printNumbers("Ceil", Math::ceil);
        // Round to nearest even number.
        printNumbers("Rint", Math::rint);


    }

    private static void printNumbers(String name, DoubleUnaryOperator op) {

        System.out.println(name + ": ");
        System.out.println(THREE_INT + " -> " + op.applyAsDouble(THREE_INT));
        System.out.println(THREE_ONE + " -> " + op.applyAsDouble(THREE_ONE));
        System.out.println(THREE_FIVE + " -> " + op.applyAsDouble(THREE_FIVE));
        System.out.println(THREE_SEVEN + " -> " + op.applyAsDouble(THREE_SEVEN));

    }


}
