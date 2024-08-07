package com.bookref.effectiveJava.methods;

public class CheckParaForValidity {


    /**
     *
     * Item:49
     *
     * @param a
     * @param b
     * @return
     *
     *  Remember to note all exception which may occur.
     * @throws ArithmeticException When either para appear to be negative
     */
    public static int add (int a, int b){

        if (a <0 || b< 0){
            throw new ArithmeticException("Negative number");
        }else {
            return a+b;
        }
    }

}
