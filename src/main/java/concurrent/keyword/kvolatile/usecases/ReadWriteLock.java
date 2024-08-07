package concurrent.keyword.kvolatile.usecases;

/**
 * Also other use-case, is to remove the lock on the read access,
 * instead marking the variable as `volatile` instead,
 * in this case, there is no cost for read lock, but still when
 * any write / update happen, the result is instantly visible
 * to all other threads.
 */
public class ReadWriteLock {

    private volatile int aggregationCount;

    // No read lock.
    public int getAggregationCount() {
        return aggregationCount;
    }

    public synchronized  int increment() {
        return aggregationCount++;
    }

}
