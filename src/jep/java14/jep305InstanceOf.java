package jep.java14;

public class jep305InstanceOf {


    public static void main(String[] args) {

        var obj = "Test String";

        // Prior to Java14, explicit cast is required.
        if (obj instanceof String) {
            String str = (String) obj;
            int len = str.length();
            // ...
        }

        // Under JEP305, variable declaration can be done as part of the `instanceOf` clause.
        // It's more of a syntax sugar thing.
        if (obj instanceof String str) {
            int len = str.length();
        }
    }
}
