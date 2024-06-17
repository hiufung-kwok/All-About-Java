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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class RoundTest {

    double value = 12345.6789;
    int iterations = 1000000;

    DecimalFormat df = new DecimalFormat("#.##");


    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void primitive() {
        // Place the first method code here
        for (int i = 0; i < iterations; i++) {
            double result = Math.round(value * 100.0) / 100.0;
        }
    }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void decimalFormatter() {
        // Place the second method code here
        for (int i = 0; i < iterations; i++) {
            double result = Double.parseDouble(df.format(value));
        }
    }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void bigDecimal() {
        // Place the second method code here
        for (int i = 0; i < iterations; i++) {
            double result = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    }


    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(RoundTest.class.getSimpleName())
                .forks(3)
                .build();

        new Runner(opt).run();
    }
}
