package com.lang.math;


public class OverFlowProtection {

    public static void main(String[] args) {

        // Proper way to perform arithmetic calculation, when Big decimal can't be used.
        // This is the same for Long.
        int intMax = Integer.MAX_VALUE;
        try {
            System.out.println(Math.addExact(intMax, 1));
        } catch (ArithmeticException ex) {
            System.out.println("Calculation over / underflow, with values: " + intMax + " " + 1);
            System.out.println(ex.getMessage());
        }

        // However for Float and Double, no exception will be thrown.
        // Instead, the result will turn to positive || negative infinite.
        float floatMax = Float.MAX_VALUE;
        float floatResult = floatMax + Float.MAX_VALUE;
        if (Float.isInfinite(floatResult)) {
            System.out.println("Float, overflow");
        }


    }
}
