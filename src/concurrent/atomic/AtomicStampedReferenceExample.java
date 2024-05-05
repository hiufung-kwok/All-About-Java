package concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceExample {

    public static void main(String[] args) {
        // Create an AtomicStampedReference with an initial value "A" and initial stamp 0
        AtomicStampedReference<String> atomicRef = new AtomicStampedReference<>("A", 0);

        // Perform a compare-and-set operation
        String expectedValue = "A";
        int expectedStamp = 0;
        String newValue = "B";
        int newStamp = 1;

        boolean result = atomicRef.compareAndSet(expectedValue, newValue, expectedStamp, newStamp);

        // Check if the operation succeeded
        if (result) {
            System.out.println("Atomic update successful. New value: " + atomicRef.getReference() +
                    ", New stamp: " + atomicRef.getStamp());
        } else {
            System.out.println("Atomic update failed. Current value: " + atomicRef.getReference() +
                    ", Current stamp: " + atomicRef.getStamp());
        }

        // Attempt another compare-and-set operation with the same expected value but a different stamp
        expectedStamp = 0; // Reset the stamp
        newStamp = 2;      // Change the stamp value
        result = atomicRef.compareAndSet(expectedValue, newValue, expectedStamp, newStamp);

        // Check if the operation succeeded
        if (result) {
            System.out.println("Atomic update successful. New value: " + atomicRef.getReference() +
                    ", New stamp: " + atomicRef.getStamp());
        } else {
            System.out.println("Atomic update failed. Current value: " + atomicRef.getReference() +
                    ", Current stamp: " + atomicRef.getStamp());
        }
    }
}
