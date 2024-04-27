package concurrent.conceptual.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
 * Functioning like a lock, the different is lock and unlock need to be 
 * proceed within the same thread, but Semaphore is not limited to - having 
 * global scope.
 * 
 * usually used to control the asset access, work greatly on singleton object,
 * because only one instance created and it can used as a controller object.
 */
public class App {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		
		Semaphore sem = new Semaphore (1);
		
		//Acquire gonna wait if not permit is available
		sem.acquire();
		
		sem.release();
		
		System.out.print("Available permits: " + sem.availablePermits() );

		*/
		
		Connection.getInstance().connect();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i=0 ; i<200 ; i++) {
			executor.submit(new Runnable () {

				@Override
				public void run() {
					Connection.getInstance().connect();
				}	
			});
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}


}
