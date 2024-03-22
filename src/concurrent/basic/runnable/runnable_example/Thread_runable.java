package concurrent.basic.runnable.runnable_example;

public class Thread_runable implements Runnable{

	@Override
	public void run() {
		//Action when thread start
		String Demo_words [] = {
				"Apple Mac Air",
				"Apple Mac Pro",
				"Apple Iphone"
		};
		
		boolean Continue = true;

		/* Print out String on array Demo_words in order. 
		 * Try to sleep 2s for every interval.
		 * 
		 * It will throw exception when called when 
		 * still in sleep mode. 
		 */
		for (int i=0 ; i<Demo_words.length && Continue ; i++) {

			String T_name = Thread.currentThread().getName();
			System.out.format("%s: %s%n", T_name, Demo_words[i]);

			//Sleep for awhile
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("I wasn't done!");
				System.out.println("Cleaning up......");
				Continue = false;

			}
		}

	}
	

}
