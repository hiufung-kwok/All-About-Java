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

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class ArrayTest {

    int size = 1000000;


    List<Integer> arrayList = new ArrayList<>();
    List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayList() {
        // Place the first method code here
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void syncList() {
        // Place the second method code here
        for (int i = 0; i < size; i++) {
            syncList.add(i);
        }
    }



    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(ArrayTest.class.getSimpleName())
                .forks(2)
                .build();

        new Runner(opt).run();
    }
}
