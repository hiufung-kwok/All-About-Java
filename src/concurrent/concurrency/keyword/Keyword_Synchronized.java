package concurrent.concurrency.keyword;

/* Following show the usage of synchronized keyword, 
 * Each thread run for loop 1000 times to increment, the amount of count.
 * However as var count belong to parent class, but the time thread_1 fetch, ++ and increment it.
 * Thread_2 may incremented for several times already, but over-write by Thread_1 (Over-lapped)
 * There for result is less what it should be. 
 * 
 * By adopting the synchronized keyword, lock is established on class creation and 
 * only one entry is allowed for access, hence by the time Thread_1 incrementing the 
 * count, Thread_2 need to queue up for it.  
 */



public class Keyword_Synchronized {
	
	private int count = 0;
	
	public synchronized void increment() {
		count++;
		
	}

	public static void main(String[] args) {
		Keyword_Synchronized sync = new Keyword_Synchronized();
		sync.dowork();
	}
	
	
	public void dowork() {
		//Put it on lambda
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i=0 ; i<10000 ; i++) {
				//	count++;
					increment();
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i=0 ; i<10000 ; i++) {
				//	count++;
					increment();
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		//Wait till both thread done their work.
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Won't count it right at first time, cuz count is var
		 * from parent class, 
		 */
		System.out.println("Count: " + count);
		
	}

}
