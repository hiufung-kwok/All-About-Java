package concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceExample_2 {
    public static void main(String[] args) {
        String initialRef = "initialValue";
        int initialStamp = 0;
        AtomicStampedReference<String> atomicStampedRef = new AtomicStampedReference<>(initialRef, initialStamp);

        // Simulate an update to the reference and stamp
        String newRef = "newValue";
        int newStamp = 1;
        atomicStampedRef.set(newRef, newStamp);

        // Get the current reference and stamp
        int[] stampHolder = new int[1];
        String currentRef = atomicStampedRef.get(stampHolder);

        // The stampHolder[0] will be updated with the current stamp
        int currentStamp = stampHolder[0];

        System.out.println("Reference: " + currentRef);
        System.out.println("Stamp: " + currentStamp);
    }
}
