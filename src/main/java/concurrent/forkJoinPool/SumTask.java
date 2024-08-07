package concurrent.forkJoinPool;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask< Long > {
    private final long[] array;
    private final int low;
    private final int high;

    public SumTask(long[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Long compute() {
        if (high - low <= 10) {
            // If the task is small enough, just perform the calculation
            long sum = 0;
            for (int i = low; i < high; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // If the task is too large, divide it into smaller tasks
            int mid = (low + high) / 2;
            SumTask left = new SumTask(array, low, mid);
            SumTask right = new SumTask(array, mid, high);
            // Fork is non-blocking, so the execution can move on to `right.compute()`
            left.fork();
            Long rightResult = right.compute();
            Long leftResult = left.join();
            return leftResult + rightResult;
        }
    }
}