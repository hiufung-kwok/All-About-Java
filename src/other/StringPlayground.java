package other;

import java.util.stream.IntStream;

public class StringPlayground {

    public static void main(String[] args) {

        String hello = " Hello World! ";

        String s1 = "S1";
        String s2 = "S2";
        String s3 = "S3";
        String s4 = "S4";


        // Concat
        String s5 = s1.concat(s2);
        System.out.println(s5);


        // Sub String
        String subWorld = hello.substring(0,5);
        System.out.println(subWorld);

        // Upper class
        System.out.println(hello.toUpperCase());

        // Check empty.
        System.out.println(hello.isEmpty());

        // Trim both sides.
        System.out.println("Trim: " + hello.trim());

        // Replace
        System.out.println(hello.replace('l', 'L'));

        // Split
        String [] arr = hello.split(" "); // [Hello, World]


        // Contain
        Boolean hasHello = hello.contains("Hello");

        // To char arr
        hello.toCharArray();

        // Start with.
        System.out.println(hello.startsWith("H"));

        // Lowercase
        System.out.println(hello.toLowerCase());

        // Format a String
        String s = String.format("Name: %s, Age: %d", "Alice", 30); // "Name: Alice, Age: 30"

        String oneString = String.join(", ", "a", "b", "c"); // "a, b, c"

        System.out.println(hello.indexOf("llo"));

        // Builder is faster, but not threat-safe
        // Buffer is sync, but slow.
        // Ideally, should allocate one SB per thread, to have both performance and thread-safe.
        StringBuilder sb = new StringBuilder("Hello");
        StringBuffer sbf = new StringBuffer("Hello");


        boolean result = "12345".matches("\\\\\\\\\\\\\\\\d+");
        System.out.println("One or more numbers: " + result);

        // Reverse
        String versed = new StringBuilder(hello).reverse().toString();
        System.out.println(versed);


        // Compare ignore cass
        boolean sameIgnoreCase = "hello".equalsIgnoreCase("HELLO");
        System.out.println(sameIgnoreCase);

        // getBytes, encodes the string into a sequence of bytes using the platform's
        // default charset.
        byte[] bytes = "Hello".getBytes();


        // StartWith, with index
        boolean startWithBool = "HelloWorld".startsWith("World", 5);

        boolean regionalMatch = "HelloWorld".regionMatches(0, "Hello", 0 , 5);

        // Replace all
        System.out.println("HelloWorld".replaceAll("l", "x"));

        // Replace the first one.
        "HelloWorld".replaceFirst("l", "L");

        // String to intStream, return an IntStream of Unicode code points from the string.
        IntStream helloStream = hello.codePoints();


        String joinned = String.join("Hello", "world");

        // Composite a string from partial Char[ ]
        char[] chars ={'a', 'b', 'c', 'd', 'e'};
        String charArr = new String(chars, 1, 3);
        System.out.println(charArr);

        // Chars( ) return a IntStream instead of char []
        IntStream charStream = hello.chars();

        // End with
        boolean endsWith = "Hello".endsWith("lo");















    }
}
