package concurrent.keyword.kvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Similar but this time wrapped with AtomicInt, then it guarantee it always print 2000.
 * Ref: https://www.baeldung.com/java-volatile-variables-thread-safety
 */
public class VolatileAtomic {

    static AtomicInteger count = new AtomicInteger(0);

    static void increment() {
        count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int index=0; index<1000; index++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int index=0; index<1000; index++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}


