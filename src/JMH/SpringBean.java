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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class SpringBean {
    class NormalObject {
        // Normal object class
    }

    @Configuration
    class AppConfig {
        @Bean
        @org.springframework.context.annotation.Scope("prototype")
        public PrototypeBean prototypeBean() {
            return new PrototypeBean();
        }
    }

    class PrototypeBean {
        // Prototype bean class
    }


    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    final int ITERATIONS = 1000000;

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void objectCreationNormal() {
        // Place the first method code here
        int intResult = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            NormalObject obj = new NormalObject();
        }
    }

    @Benchmark
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void objectCreationSpring() {
        // Place the second method code here
        for (int i = 0; i < ITERATIONS; i++) {
            PrototypeBean bean = context.getBean(PrototypeBean.class);
        }
    }



    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(SpringBean.class.getSimpleName())
                .forks(2)
                .build();

        new Runner(opt).run();
    }
}
