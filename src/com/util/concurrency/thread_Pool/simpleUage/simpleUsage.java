package com.util.concurrency.thread_Pool.simpleUage;
//Ref: http://tutorials.jenkov.com/java-concurrency/threadlocal.html
public class simpleUsage {

	public static class NewTask implements Runnable {
		
		private ThreadLocal<Integer> t_local = new ThreadLocal<Integer> ();

		@Override
		public void run() {
			
			t_local.set( (int) (Math.random() * 100D));
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
			
			System.out.println("Value: " + t_local.get());
			
		}
		
		
		public static void main(String[] args) throws InterruptedException {
			NewTask shareInstance = new NewTask();

	        Thread t1 = new Thread(shareInstance);
	        Thread t2 = new Thread(shareInstance);
	        
	        t1.start();
	        t2.start();

	        t1.join();
	        t2.join(); 
		}
		
	}
	
	
	
}
