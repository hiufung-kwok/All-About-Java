package designPattern.proxy;

import java.util.HashMap;

public class CachedSparkComputation implements SMJComputation{

    private static HashMap<Long, Integer> cache = new HashMap<>();

    @Override
    public Integer getAggregationCount(Long ts) {
        Integer result = cache.get(ts);
        if (result == null) {
            // Only do the actual computation now.
            result = new SparkComputation().getAggregationCount(ts);
            return cache.put(ts, result);
        } else {
            return result;
        }
    }
}
