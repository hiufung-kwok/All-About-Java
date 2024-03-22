package concurrent.conceptual.Semaphores;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance = new Connection ();
	
	/*
	 * If the second para set true, which make a queue for q up all 
	 * incoming .acquire request and proceed it in order.
	 */
	private static Semaphore sem = new Semaphore(10,true);
	
	private int connections = 0;
	private Connection () {
		
	}
	
	
	public static Connection getInstance() {
		return instance;
	}
	public  void connect () {
		try{
		sem.acquire();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		synchronized (this) {
			connections++;
			System.out.println("Current connection: " + connections);
		}
		
		try {
			System.out.println("Sleeping:" + connections);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
		}
		
		sem.release();
		
	}
}
