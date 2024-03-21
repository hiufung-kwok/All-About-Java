package concurrent.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/* Following is the segment of code which demo how to 
 * take advantage of ExecutorService to manage multiple 
 * thread and reduce the overhead of thread creation.
 * 
 */
class Thread_Pool_Main {
	
	public static void main (String[] args) {
		
		
		//By using Executor package
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for( int i=0 ; i<5 ; i++) {
			executor.submit(new Thread_Pool_Example(i));
		}
		
		executor.shutdown();
		
		System.out.println("All tasks submitted. ");
		
		/*It indicate how much time executor 
		 * gonna wait before terminate all thread.
		 */
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed. ");
	}
}
