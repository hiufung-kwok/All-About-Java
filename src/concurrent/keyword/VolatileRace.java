package concurrent.keyword;

/**
 * Ref: https://www.baeldung.com/java-volatile-variables-thread-safety
 */
public class VolatileRace {

    static volatile int count = 0;

    static void increment() {
        count++;
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


