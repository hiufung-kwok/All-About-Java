package concurrent.basic.example_runnable;

/**
 * Join similar to sleep, while it waiting to join it basically sleeping.
 * This time we have a runnable whiich simulate a heavy load process, let say 
 * take ~10s. Once main thread spawn new thread to handle the so call 
 * heavy load process. It would call t.joins() and wait for the side thread do
 * its job and only terminate it self when 10s is over. 
 * 
 * Instead of terminate itself before the heavy load task done!
 * 
 * Ref: https://docs.oracle.com/javase/tutorial/essential/concurrency/join.html
 */
public class HelloJoins implements Runnable{

	private final static String sideT = "(Heavy Load task): ";
	private final static String mainT = "(Main): ";
	
	@Override
	public void run() {
		System.out.println(sideT + "start" );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sideT + "End");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(mainT + "Start");
		Thread t = new Thread(new HelloJoins());
		t.start();
		t.join();
		System.out.println(mainT + "End");
		
	}

	
}
