package concurrent.conceptual.cyclicBarrier;


import java.util.concurrent.CyclicBarrier;

/**
 * It's more like a synchronize point, in the world of parallel programming,
 * you want each thread to progress as fast as it can, however, sometime you
 * would like to have manual wait point, and only let thread to progress on the next stage when all
 * threads completed the current stage.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("All tasks completed for the current state, moving on to the next stage. ");
        });

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Task(barrier), "Thread " + (i + 1)).start();
        }

    }



    static class Task implements Runnable {

        private final CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " working on job stage 1. ");
                Thread.sleep(2000);
                System.out.println("Thread: " + Thread.currentThread().getName() + " waiting on the barrier. ");
                barrier.await();
                System.out.println("Thread: " + Thread.currentThread().getName() + " working on job stage 2. ");
                Thread.sleep(2000);
                System.out.println("Thread: " + Thread.currentThread().getName() + " waiting on the barrier. ");
                barrier.await();
                System.out.println("Thread: " + Thread.currentThread().getName() + " working on job stage 3. ");
                Thread.sleep(2000);

                System.out.println("Thread: " + Thread.currentThread().getName() + " completed all assigned portion of work. ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
