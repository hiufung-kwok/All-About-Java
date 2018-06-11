package com.util.concurrency.basic.example_runnable;

/**
 * Demonstrate how to use Thread.sleep() call, it would simply make current thread to sleep for
 * given ms. 
 * 
 * Ref: https://docs.oracle.com/javase/tutorial/essential/concurrency/examples/SleepMessages.java
 */
public class HelloPause {

	final static String stmt[] = {
			"Hello world",
			"Hello Java",
			"Hello OpenSrc",
			"Hello Concurrent"
	};
	
	public static void main(String[] args) {
		
		
		/**
		 * A for loop print out msg, and sleep for 4s for every print.
		 * Noted that no new thread is spawn in this case, all happen on Main thread, 
		 * which mean when Thread.sleep is execute, it sleep the main thread. Which simply stop the world.
		 */
		
		for (String str: stmt) {
			System.out.println(str);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.err.println("Got interupteddddddd!");
			}
		}
	}
}
