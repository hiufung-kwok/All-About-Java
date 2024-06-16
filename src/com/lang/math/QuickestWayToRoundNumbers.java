package com.lang.math;

/**
 * Waiting for a micro-benchmark, but I'm confident that this is the quickest,
 * compare to DecimalFormat and BigDecimal classes.
 */
public class QuickestWayToRoundNumbers {

    public static void main(String[] args) {

        float yourFloat = 3.14159f;
        float roundedValue = Math.round(yourFloat * 100.0f) / 100.0f;
        System.out.println(roundedValue);  // Output: 3.14

    }
}
