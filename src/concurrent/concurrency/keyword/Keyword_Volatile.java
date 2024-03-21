package concurrent.concurrency.keyword;

/*
 * Volatile make sure runtime dun cache var value.
 * In this situation, running still stay true after shutdown is call for a period of time,
 * cuz JVM cache the value of running. And only update it periodically. 
 * Till JVM update the status of variable running, then loop would terminate. 
 */



import java.util.Scanner;

class Processor extends Thread{

	private volatile boolean running = true;
	
	public void run () {
		
		while (running) {
			try {
				System.out.println("Hello");
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown () {
		running = false;
	}
}

public class Keyword_Volatile {
	
	public static void main (String[] args) {
		
		Processor proc1 = new Processor();
		
		proc1.start();
		
		System.out.println("Press return to stop...");
		Scanner scanner = new Scanner (System.in);
		//Would stop once any key pressed from keyboard.
		scanner.nextLine();
		
		proc1.shutdown();
		
		
		
	}

}
