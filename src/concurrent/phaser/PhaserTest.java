package concurrent.phaser;

import java.util.concurrent.Phaser;

public class PhaserTest {

    public static void main(String[] args) {
        final int numTasks = 3;
        final Phaser phaser = new Phaser(numTasks);

        for (int i = 0; i < numTasks; i++) {
            final int taskId = i;
            Runnable task = () -> {
                System.out.println("Task " + taskId + " started");
                // Perform task-specific operations
                phaser.arriveAndAwaitAdvance(); // Synchronize with other tasks
                System.out.println("Task " + taskId + " completed");
            };
            new Thread(task).start();
        }
    }
}