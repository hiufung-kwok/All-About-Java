package concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

class SharedResource {
    private String data;

    public SharedResource(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

public class AtomicReferenceExample {
    public static void main(String[] args) {
        // Create a shared atomic reference initialized with null
        AtomicReference<SharedResource> atomicReference = new AtomicReference<>(null);

        // Create and start multiple threads to update the shared reference
        for (int i = 1; i <= 5; i++) {
            final int threadNumber = i;
            new Thread(() -> {
                // Create a new SharedResource instance with thread-specific data
                SharedResource resource = new SharedResource("Data from Thread " + threadNumber);

                // Atomically set the shared reference if it's currently null
                boolean result = atomicReference.compareAndSet(null, resource);

                if (result) {
                    System.out.println("Thread " + threadNumber + " successfully set the shared resource.");
                } else {
                    System.out.println("Thread " + threadNumber + " failed to set the shared resource.");
                }
            }).start();
        }

        // Wait for a short period to allow threads to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieve and print the final value of the shared reference
        SharedResource finalResource = atomicReference.get();
        if (finalResource != null) {
            System.out.println("Final value of the shared resource: " + finalResource.getData());
        } else {
            System.out.println("No shared resource was successfully set.");
        }
    }
}
