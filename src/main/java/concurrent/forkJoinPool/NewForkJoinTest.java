package concurrent.forkJoinPool;

import java.util.concurrent.RecursiveTask;

public class NewForkJoinTest extends RecursiveTask {
    @Override
    protected Object compute() {
        System.out.println("Override me for the actual logic");
        return null;
    }
}
