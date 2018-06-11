package com.util.concurrency.basic.waitNotify;
import java.util.Scanner;

public class Wait_Notify {

	/*
	 * This file mainly discuss about how to adopt wait && notify
	 * on Producer && Consumer pattern. In this example, method produce
	 * only ran half way then hit method call wait( ), only resume when got 
	 * noticed by other thread, in this case is consume ( ). consume send out 
	 * signal notify once user press any key.
	 */
	
	
	public void produce () throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running ...");
			/* Wait can only be call on synchronized code block, as 
			 * If method allow multiple entry, truly there is not
			 * point putting wait( ).  
			 * 
			 * It won't resume till two things happen.
			 *  - For this thread to regain the control of this lock.
			 *  - Notify by other.
			 */
			wait();
			System.out.println("Resumed. ");
		}
	}
	
	public void consume() throws InterruptedException {
		
		Scanner scanner = new Scanner (System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key. ");
			scanner.nextLine();
			System.out.println("Return key pressed. ");
			notify();
			/*
			 * In this case lock is obtained by consume,hence only print out 
			 * Resumed after 5s.
			 */
			
			Thread.sleep(5000);
		}
		
	}
	

}
