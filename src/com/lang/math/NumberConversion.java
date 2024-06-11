package com.lang.math;

/**
 * Despite Integer.decode( ) and Integer.parseInt( ) serve
 * similar purpose, but parseInt require dev to know the radix
 * in advanced, but not the case for decode ( )
 */
public class NumberConversion {

    public static void main(String[] args) {

        // Binary string (base 2)
        String binaryString = "101";
        int binaryValue = Integer.parseInt(binaryString, 2);
        System.out.println("Binary to int: " + binaryValue); // Output: 5

        // Other bases for comparison
        String decimalString = "123";
        int decimalValue = Integer.parseInt(decimalString);
        System.out.println("Decimal to int: " + decimalValue); // Output: 123

        String hexString = "7f";
        int hexValue = Integer.parseInt(hexString, 16);
        System.out.println("Hexadecimal to int: " + hexValue); // Output: 127

        String octalString = "75";
        int octalValue = Integer.parseInt(octalString, 8);
        System.out.println("Octal to int: " + octalValue); // Output: 61

        try {
            Integer decimal = Integer.decode("123");
            Integer hex = Integer.decode("0x7F");
            Integer octal = Integer.decode("075");

            System.out.println("Decimal: " + decimal); // Output: 123
            System.out.println("Hexadecimal: " + hex); // Output: 127
            System.out.println("Octal: " + octal); // Output: 61
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }

    }
}
