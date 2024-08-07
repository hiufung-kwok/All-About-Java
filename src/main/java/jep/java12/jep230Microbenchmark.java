package jep.java12;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * A dummy Benchmark setup.
 * Ref: https://www.baeldung.com/java-microbenchmark-harness
 */
public class jep230Microbenchmark {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void init() {
        // Do nothing
    }
}
