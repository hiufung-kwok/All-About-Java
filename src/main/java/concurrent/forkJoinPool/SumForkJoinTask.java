package concurrent.forkJoinPool;

import java.util.concurrent.ForkJoinTask;

/**
 * Basic unit to implement for ForkJoinPool.
 */
public class SumForkJoinTask extends ForkJoinTask {
    @Override
    public Object getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Object value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
