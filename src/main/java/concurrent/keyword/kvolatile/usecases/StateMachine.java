package concurrent.keyword.kvolatile.usecases;

/**
 * In the use case of state machine, the state of the runnable / code should be
 * visible to all threads, without any caching, so that other threads can act accordingly.
 */
public class StateMachine {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            computation();
        }
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    private void computation () {

    }

}
