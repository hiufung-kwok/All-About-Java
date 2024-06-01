package other;

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





    }
}
