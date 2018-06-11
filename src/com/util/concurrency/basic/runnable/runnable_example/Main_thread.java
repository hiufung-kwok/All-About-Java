package com.util.concurrency.basic.runnable.runnable_example;

public class Main_thread {

	public static void main(String[] args) {
		//Take runable
		System.out.println("Run thread");
		Thread t = new Thread(new Thread_runable() );
		t.start();
		/*
		/* As the thread start, it will sleep for two seconds 
		 * after every print operation. So what happen if got interupt
		 * after 1s when it still sleeping?
		 */
		
		try {
			System.out.println("Trying");
			/* As it send out the signal after 1s, example class
			 * would thread InterruptedException and print out 
			 * "I wasn't done" along with printStackTrace()
			 */
			t.join(1000);

			//Running out of patience
			t.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
