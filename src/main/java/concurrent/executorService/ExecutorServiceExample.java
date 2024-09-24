package concurrent.executorService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
                () -> "Task 1",
                () -> "Task 2",
                () -> "Task 3"
        );

        try {
            // invokeAll: Executes all tasks and waits for them to complete
            List<Future<String>> results = executor.invokeAll(tasks);
            for (Future<String> result : results) {
                System.out.println(result.get());
            }

            // invokeAny: Executes the tasks and returns the result of the first completed task
            String result = executor.invokeAny(tasks);
            System.out.println("First completed task: " + result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
