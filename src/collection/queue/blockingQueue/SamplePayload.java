package collection.queue.blockingQueue;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class SamplePayload implements Delayed {

    private String name ;
    private long start = System.currentTimeMillis();
    private long time ;

    public SamplePayload(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(@NotNull Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "SamplePayload{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", time=" + time +
                '}';
    }
}
