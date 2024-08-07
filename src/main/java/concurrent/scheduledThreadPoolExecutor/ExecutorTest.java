package concurrent.scheduledThreadPoolExecutor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {


    public static void main(String[] args) {



        try (ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3)){
            executor.schedule(
                    () -> System.out.println("Test")
                    , 100, TimeUnit.MILLISECONDS);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
