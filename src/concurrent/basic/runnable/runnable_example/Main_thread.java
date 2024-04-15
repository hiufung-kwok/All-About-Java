package concurrent.basic.runnable.runnable_example;

/**
 * Ref:
 * https://www.geeksforgeeks.org/java-multithreading-tutorial/
 *
 * Runnable is like a container for the instruction, which helps to hide all other methods
 * that average programmer don't need to be touch, and expose the run() only.
 *
 */
public class Main_thread {

	public static void main(String[] args) {
		//Take runnable
		System.out.println("Run thread");
		Thread t = new Thread(new Thread_runnable() );
		t.start();
		/*
		/* As the thread start, it will sleep for two seconds 
		 * after every print operation. So what happen if got interrupted
		 * after 1s when it's still sleeping?
		 */
		
		try {
			System.out.println("Trying");
			/* As it sends out the signal after 1s, example class
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
