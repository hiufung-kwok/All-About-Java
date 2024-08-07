package com.hiuk.test.deadLock;
/*
*
* Simple example from tutorial point, to demonstrate how deadlock can be happen.
*
* Ref: https://www.tutorialspoint.com/java/java_thread_deadlock.htm
* */
public class DeadLockEx {

    private static Object L1 = new Object();
    private static Object L2 = new Object();


    /*
    * Dead lock would happen in this case, as both demo1 and deom2 require lock
    * 1 and 2 to perform the whole operation. However they are having a different order
    * for fetching lock, Demo1 look for L1 then L2, Demo2 do the opposite. So by giving
    * this situation.
    *
    * When main execute, it cause a deadlock for Demo1 keep L1 and look for L2, Demo2 keep L2 and look for L1.
    * However none of the thread would release the lock obtained before perform the operation.
    *
    * Way out:
    *  - Either make it as a single sync method, only one thread is allow to execute selected wrapper
    *  method one at a time.
    *
    *  - Or make simply modify the order of lock fetching. By having the same order of lock fetching.
    *  Deadlock wouldn't happen cause the whole operation would become atomic-ish.
    *   - Can't get L2 before L1, by giving the assumption that only one Thread can have L1.(Single lane highway)
    * */
    public static void main(String[] args) {


    }

    private static class TDemo1 extends Thread {

        public void run() {
            synchronized (L1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (L2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }

    }


    private static class TDemo2 extends Thread {

        public void run() {
            synchronized (L2) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (L1) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }

    }



}
