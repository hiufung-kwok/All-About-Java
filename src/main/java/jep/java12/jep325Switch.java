package jep.java12;

import static java.util.Calendar.*;


/**
 * New way of writing `switch` statement, in order to simply day to day work.
 * Ref: https://openjdk.org/jeps/325
 */
public class jep325Switch {

    public static void main(String[] args) {

        int day = 1;

        // New switch allow multiple options and lambda-like expression.
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY                -> System.out.println(7);
            case THURSDAY, SATURDAY     -> System.out.println(8);
            case WEDNESDAY              -> System.out.println(9);
        }

    }
}
