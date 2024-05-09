package concurrent.future.completable;

import java.util.concurrent.CompletableFuture;

public class AsynchronousCallbackExample {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> fetchData())
                .thenApply(data -> processData(data))
                .thenAccept(result -> displayResult(result))
                .exceptionally(ex -> {
                    System.err.println("Error: " + ex.getMessage());
                    return null;
                });

        System.out.println("Main thread is not blocked.");


        // Wait for the async thread.
        Thread.sleep(1000);
    }

    private static String fetchData() {
        try {
            Thread.sleep(100);
            System.out.println("Fetching data on async thread");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Data";
    }

    private static String processData(String data) {
        try {
            Thread.sleep(500);
            System.out.println("Processing data on async thread");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Processed " + data;
    }

    private static void displayResult(String result) {
        System.out.println(result);
    }
}
