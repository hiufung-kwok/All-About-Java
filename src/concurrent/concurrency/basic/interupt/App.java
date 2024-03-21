package concurrent.concurrency.basic.interupt;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/*
 * Following code show a of the way that interrupt may append and how to deal with it.
 * Intrupte signal can be checked by isInterrupted() call, interrupt is not thread to force quit,
 * but more to told thread to prepare to wrap up as the thread may be terminated earlier than expected. 
 */
public class App {
	
	private static class callable implements Callable <Void> {

		@Override
		public Void call()  {
			Random ran = new Random();

			for (int i=0 ; i<1E8 ; i++) {
				//Interrupt != force quit
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("We've been interrupted");
					break;
				}
				System.out.println(Math.sin(ran.nextDouble()) );
			}
			
			return null;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting");
	
		ExecutorService exec = Executors.newCachedThreadPool();		
		Future<?> fu = exec.submit( new callable () );
		//Gonna wait for all thread done.
		exec.shutdown();
		
		Thread.sleep(500);
		
		//Interrupt thread
		fu.cancel(true);
		
		exec.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Finished. ");
		

	}

}
