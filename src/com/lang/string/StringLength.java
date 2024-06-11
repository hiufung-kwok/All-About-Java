package com.lang.string;

public class StringLength {
    public static void main(String[] args) {
        String asciiString = "Hello, World!";
        System.out.println("ASCII String: " + asciiString);
        System.out.println("Length: " + asciiString.length());

        String utf8String = "你好, 世界!"; // Chinese for "Hello, World!"
        System.out.println("UTF-8 String: " + utf8String);
        System.out.println("Length: " + utf8String.length());
        System.out.println("Code Point Count: " + utf8String.codePointCount(0,utf8String.length()));

        String unicodeString = "😊🌍"; // Emoji for "smiling face" and "earth globe"
        System.out.println("Unicode String: " + unicodeString);
        System.out.println("Length: " + unicodeString.length());
        System.out.println("Code Point Count: " + unicodeString.codePointCount(0, unicodeString.length()));

    }
}
