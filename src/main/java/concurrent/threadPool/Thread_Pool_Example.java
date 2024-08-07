package concurrent.threadPool;


public class Thread_Pool_Example implements Runnable {

	private int id;
	
	public Thread_Pool_Example (int id) {
		this.id = id;
	}
	

	@Override
	public void run() {
		System.out.println("Starting: " + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed: " + id);
		
	}
}

 