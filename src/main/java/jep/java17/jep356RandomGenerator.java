package jep.java17;


import java.util.random.RandomGeneratorFactory;

/**
 * All legacy code are now consolidated and implemented a common inteface.
 */
public class jep356RandomGenerator {

    public static void main(String[] args) {
        var intStream = RandomGeneratorFactory.of("Random")
                .create()
                .ints(1, 0,100);

        System.out.println(intStream.count());
    }
}
