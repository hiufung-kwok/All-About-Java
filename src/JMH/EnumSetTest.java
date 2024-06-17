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

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class EnumSetTest {

    int iterations = 1_000_000;

    public enum SampleEnum { A, B, C, D, E }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void enumSet() {
        // Place the first method code here
        EnumSet<SampleEnum> enumSet = EnumSet.noneOf(SampleEnum.class);
        for (int i = 0; i < iterations; i++) {
            enumSet.add(SampleEnum.A);
            enumSet.contains(SampleEnum.A);
            enumSet.remove(SampleEnum.A);
        }
    }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void enumHashSet() {
        // Place the second method code here
        Set<SampleEnum> hashSet = new HashSet<>();
        for (int i = 0; i < iterations; i++) {
            hashSet.add(SampleEnum.A);
            hashSet.contains(SampleEnum.A);
            hashSet.remove(SampleEnum.A);
        }
    }



    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(EnumSetTest.class.getSimpleName())
                .forks(2)
                .build();

        new Runner(opt).run();
    }
}
