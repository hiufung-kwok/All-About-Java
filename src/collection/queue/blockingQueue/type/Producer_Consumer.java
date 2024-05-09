package collection.queue.blockingQueue.type;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/* Traditional producer && Consumer example,
 * Two thread running concurrently, one act producer, keep fill up the queue to maximum
 * which is 10, on the other hand consumer keep take item from queue on every 1/10 second. 
 * As BlockingQueue is Sync class, it simply the application, worry one less thing.
 */



public class Producer_Consumer {

	//It's thread safe.
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer> (10);
	
	public static void main (String[] args ) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable () {
			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();		
				}	
			}	
		});
		
		Thread t2 = new Thread(new Runnable () {
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();		
				}	
			}	
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
	
	private static void producer () throws InterruptedException {
		Random random = new Random();
		
		while (true) {
			int value = random.nextInt(100);
			System.out.println("Taken value: " + value );
			queue.put( value );				
		}
	}
	
	private static void consumer () throws InterruptedException {
		Random random = new Random();

		while(true) {
			try {
				Thread.sleep(100);
				if (random.nextInt(10) == 0) {
					Integer value = 0;
					value = queue.take();
					System.out.println("Taken value: " + value + "; Queue size is: " + queue.size() );
				}
			} catch (InterruptedException e) {

			}
		}
	}
	
}
