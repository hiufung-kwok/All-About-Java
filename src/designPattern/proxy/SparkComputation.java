package designPattern.proxy;

public class SparkComputation implements  SMJComputation{
    @Override
    public Integer getAggregationCount(Long ts) {
        // Simulate the computation.
        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
