package concurrent.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {

    public static void main(String[] args) {
        final int numTasks = 3;
        final Phaser phaser = new Phaser(1); // Initial phase is 1 (main thread)

        for (int i = 0; i < numTasks; i++) {
            final int taskId = i;
            Runnable task = () -> {
                System.out.println("Task " + taskId + " started");
                // Perform task-specific operations
                phaser.arrive(); // Signal arrival at this phase
                phaser.awaitAdvance(phaser.getPhase()); // Wait for all parties to complete this phase
                System.out.println("Task " + taskId + " completed");
            };
            new Thread(task).start();
        }

        // Main thread coordinating tasks
        System.out.println("Main thread waiting for all tasks to complete");
        phaser.arriveAndAwaitAdvance(); // Wait for all tasks to complete
        System.out.println("All tasks completed");
    }
}
