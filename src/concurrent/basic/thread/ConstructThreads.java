package concurrent.basic.thread;


/**
 * Basic example to show how fit custom code into a Thread then execute it.
 *
 */
public class ConstructThreads {

    static class MyThreadPrintTest extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from test Thread");
        }
    }

    static class MyThreadAnotherPrintTest extends Thread {
        @Override
        public void run() {
            System.out.println("Test print (2)");
        }
    }



    public static void main(String[] args) {

        Thread td = new MyThreadPrintTest();
        Thread td2 = new MyThreadAnotherPrintTest();

        td.start();
        td2.start();

    }
}
