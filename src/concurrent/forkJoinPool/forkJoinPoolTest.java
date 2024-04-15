package concurrent.forkJoinPool;

import java.util.concurrent.ForkJoinPool;

public class forkJoinPoolTest {

    public static void main(String[] args) {
        long[] array = new long[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Long result = pool.invoke(task);
        System.out.println("Result: " + result);
    }
}
