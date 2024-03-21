package concurrent.concurrency.future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



/**
 * Following segment of code used to demonstrate how future can be used under concurrent programming.
 * 
 * Noted that future.get( ) is blocking call, the whole thing is mean let you start up task, 
 * then work on other and return to the future task when ur own one is done and nothing else is left to process.
 */
public class App_callable {
	

	/*
	 * It will first generate a random Int between 0 - 4000, then check the result int. 
	 * Sleep accordingly if int < 2000, otherwise throw a IOException. (2000 - 4000)
	 */
	private static class customeCallable implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			
			Random random = new Random();
			int duration = random.nextInt(4000);
			
			if (duration > 2000) {
				throw new IOException("Sleeping for too long");
			}
			
			System.out.println("Starting....");
			
			try {
				Thread.sleep(duration);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Finished.");
			
			return new Integer(duration);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		//instantialize a thread pool then execute call-able task 
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> future  = executor.submit( new customeCallable() );
		executor.shutdown();
		
		/*
		 * If nothing specify, future.get would wait the thread till
		 * result return.
		 * 
		 * If any exception thrown on runnable block, future.get() 
		 * would pick it up and thrown one layer outer as ExcutionException
		 */
		try {
			System.out.println("Result is: " + future.get() );
		} catch (InterruptedException | ExecutionException e) {
			//Any exception thrown inside the call method( ) would be wrapped as ExecutionExcpetion
			System.out.println(e);
		}
		
	
	}

}
