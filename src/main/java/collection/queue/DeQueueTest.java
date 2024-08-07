package collection.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Queue v.s Deque
 * Queue is first-in first-out, new element can only be inserted at the end,
 * while insertion can be performed on Deque from both sides instead.
 */
public class DeQueueTest {
    public static void main(String[] args) {

        //Deque can operate on both end of the queue.
        ArrayDeque<String> testDeque = new ArrayDeque<>(
                Arrays.asList("a", "b", "c", "d", "e"));

        // Remove a
        testDeque.removeFirst();
        // Remove e
        testDeque.removeLast();
        // Print b
        System.out.println("The first element of Deque is " + testDeque.getFirst());

    }
}
