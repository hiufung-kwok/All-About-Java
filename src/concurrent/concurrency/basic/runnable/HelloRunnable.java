package concurrent.concurrency.basic.runnable;

/**
 * A demonstrate use of runnable interface.
 * Ref: https://docs.oracle.com/javase/tutorial/essential/concurrency/examples/HelloRunnable.java
 */
public class HelloRunnable implements Runnable{

	/**
	 * Runnable by it self is not include a thread object. Can picture as instruction set of a thread.<br>
	 * It told how a thread should be run, once any thread given chance for computing power (Execution time). <br>
	 * It will run what's in the instruction set (Runnable.run).
	 */
	@Override
	public void run() {
		System.out.println("Hello runnable!");
		
	}
	
	//Spawn a new thread, plug runnable and run.
	public static void main(String[] args) {
		
		/**
		 * In this case, when Thread.start() executed, a new Thread object got issue CPU time to spend.
		 * Then what should it do? As we plug a runnable into it. The thread would then use the CPU time to 
		 * run HellRunnalbe.run() method.
		 */
		new Thread(new HelloRunnable()).start();
	}

}
