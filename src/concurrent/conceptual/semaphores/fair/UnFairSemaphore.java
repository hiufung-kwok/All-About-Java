package concurrent.conceptual.semaphores.fair;

import java.util.concurrent.Semaphore;

/**
 * In this particular example, the fair option is turned to false, in this even the order of lock acquire can't be guarantee,
 * because there is no blocking queue maintain internally to keep the order in the case of all lock being acquired.
 *
 * tart to conduct computationThread-2
 * Start to conduct computationThread-0
 * Start to conduct computationThread-1
 * Computation completed, releasing semaphore Thread-1
 * Computation completed, releasing semaphore Thread-2
 * Start to conduct computationThread-3
 * Start to conduct computationThread-4
 * Computation completed, releasing semaphore Thread-0
 * Start to conduct computationThread-5
 * Computation completed, releasing semaphore Thread-3
 * Computation completed, releasing semaphore Thread-5
 * Computation completed, releasing semaphore Thread-4
 * Start to conduct computationThread-7
 * Start to conduct computationThread-8
 * Start to conduct computationThread-6
 * Computation completed, releasing semaphore Thread-6
 * Computation completed, releasing semaphore Thread-8
 * Start to conduct computationThread-9
 * Computation completed, releasing semaphore Thread-7
 * Computation completed, releasing semaphore Thread-9
 */
public class UnFairSemaphore {

    private final Semaphore semaphore;

    public UnFairSemaphore(int maxLimit) {
        this.semaphore = new Semaphore(maxLimit, false);
    }

    public void runComputationWithSemaphore () {
        try {
            semaphore.acquire();
            System.out.println("Start to conduct computation" + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Computation completed, releasing semaphore " + Thread.currentThread().getName());
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        UnFairSemaphore fairSemaphore = new UnFairSemaphore(3);
        for (int i = 0; i < 10 ; i++) {
            new Thread(fairSemaphore::runComputationWithSemaphore).start();
        }
    }

}
