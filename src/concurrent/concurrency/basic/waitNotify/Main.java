package concurrent.concurrency.basic.waitNotify;



public class Main {

	public static void main(String[] args) throws InterruptedException {
		final Wait_Notify wait = new Wait_Notify();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					wait.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		});
		
		
		Thread t2 = new Thread(new Runnable () {

			@Override
			public void run() {
				try {
					wait.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
