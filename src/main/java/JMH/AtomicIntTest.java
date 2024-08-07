package JMH;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@State(Scope.Thread)
public class AtomicIntTest {

    int iterations = 100000000;

    AtomicInteger atomicValueLazySet = new AtomicInteger();

    AtomicInteger atomicValueSet = new AtomicInteger();

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void primitive() {
        // Place the first method code here
        int value = 0;
        for (int i = 0; i < iterations; i++) {
            value = i;
        }
    }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void atomicLazySet() {
        // Place the second method code here
        for (int i = 0; i < iterations; i++) {
            atomicValueLazySet.lazySet(i);
        }
    }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void atomicSet() {
        // Place the second method code here
        for (int i = 0; i < iterations; i++) {
            atomicValueSet.set(i);
        }
    }


    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(AtomicIntTest.class.getSimpleName())
                .forks(3)
                .build();

        new Runner(opt).run();
    }
}
