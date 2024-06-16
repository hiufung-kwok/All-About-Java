package com.lang.math;

public class DoubleCompare {
    public static void main(String[] args) {
        double d1 = 0.1 + 0.2;
        double d2 = 0.3;
        double epsilon = 0.00001;

        boolean areEqual = Math.abs(d1 - d2) < epsilon;

        System.out.println("Are the doubles equal? " + areEqual);
    }
}

