package concurrent.conceptual.semaphores.fair;

import java.util.concurrent.Semaphore;

/**
 * In this particular example, fair lock is used, so the execution is always called in order, see the below console output.
 * The order of release may be out of order, due to the inaccuracy of Thread.sleep(1000);
 * Start to conduct computationThread-0
 * Start to conduct computationThread-1
 * Start to conduct computationThread-2
 * Computation completed, releasing semaphore Thread-1
 * Computation completed, releasing semaphore Thread-2
 * Start to conduct computationThread-3
 * Start to conduct computationThread-4
 * Computation completed, releasing semaphore Thread-0
 * Start to conduct computationThread-5
 * Computation completed, releasing semaphore Thread-4
 * Computation completed, releasing semaphore Thread-5
 * Start to conduct computationThread-6
 * Start to conduct computationThread-7
 * Computation completed, releasing semaphore Thread-3
 * Start to conduct computationThread-8
 * Computation completed, releasing semaphore Thread-7
 * Start to conduct computationThread-9
 * Computation completed, releasing semaphore Thread-6
 * Computation completed, releasing semaphore Thread-8
 * Computation completed, releasing semaphore Thread-9
 */
public class FairSemaphore {

    private final Semaphore semaphore;

    public FairSemaphore(int maxLimit) {
        this.semaphore = new Semaphore(maxLimit, true);
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
        FairSemaphore fairSemaphore = new FairSemaphore(3);
        for (int i = 0; i < 10 ; i++) {
            new Thread(fairSemaphore::runComputationWithSemaphore).start();
        }
    }

}
