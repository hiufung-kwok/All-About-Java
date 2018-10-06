package com.bookref.effectiveJava.enumAndAnnotations;

public class simpleUsage {

    public static final int DEVICE_MAC = 1;
    public static final int DEVICE_IPHONE = 2;
    public static final int DEVICE_IPAD = 3;

    /**
     * Simply Enum
     */
    enum Device {
        MAC,
        IPHONE,
        IPAD
    }


    /**
     * Enum with properties
     */
    enum Position {

        ENGINEER(25000, "HK"),
        DESIGNER(300000, "CN");


        private final int wage;
        private final String location;

//      Constructor
        Position(int wage, String location) {
            this.wage = wage;
            this.location = location;
        };
    }


    /**
     * Method call can also be packed inside enum
     */
    public enum Method {

        HALF {public double apply(double x){return x/2;}};

        public abstract double apply(double x);

    }


    /**
     * Enum with Str constructor and abstract method
     */
    public enum Interface {

//      The order does matter Implementation > Abstract
        REC("rec"){public double apply(double x, double y) { return x / y; } };

//        Member var
        private final String cmd;
//      Constructor
        Interface (String cmd) { this.cmd = cmd;}
//        Method declaration (abstract)
        public abstract double apply(double x, double y);



    }




    public static void main(String[] args) {

        /**
         * It's doesn't make sense at all, the purpose of using int as uid is to
         * make it unique. However as int is in used, it would allow some non-sense code.
         *
         * What the hack is IPAD - IPHONE?
         */
        int nonSense = DEVICE_IPAD - DEVICE_IPHONE;

        /**
         * Also compiler would help to pickup when enum is removed. Compiler would pop up a error.
         * But on the other case, int is number. Number won't get missing.
         */
//      Following statement would be error when IPAD is removed.
        Device d = Device.IPAD;


        double item = 10;
//        Result == 5
        double result = Method.HALF.apply(item);


    }

}
