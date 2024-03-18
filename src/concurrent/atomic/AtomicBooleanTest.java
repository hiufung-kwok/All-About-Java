package concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Faster, compare to synchronize keyword.
 * Violate used within the class, to guarantee the consistency.
 */
public class AtomicBooleanTest {

    public static void main(String[] args) {

        AtomicBoolean ab = new AtomicBoolean(false);

        // Some frequently used methods.

        // Only set to true, when the existing value is false,
        // may not be useful in the case of boolean, but this make sense for other types.
        ab.compareAndSet(false, true);

        // Get the existing value, then update.
        boolean oldValue = ab.getAndSet(true);



    }
}
