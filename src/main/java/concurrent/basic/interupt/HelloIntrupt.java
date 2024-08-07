package concurrent.basic.interupt;

public class HelloIntrupt implements Runnable {
	
	final static String main = "(Main thread) ";
	final static String side = "(Side thread) ";
	
	@Override
	public void run() {
		System.out.println( side + "sleep for 10s");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(side + "Main thread is rushing me, ok temrinate my self, bye:(");
			e.printStackTrace();
			return;
		}
		System.out.println(side + "Time to wake mate!");
	}
	
	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(new HelloIntrupt());
		thread.start();
		System.out.println(main + "Sleep for 3s then interupt side thread");
		Thread.sleep(3000);
		System.out.println(main + "interrupt side Thread!!");
		thread.interrupt();
	}

	
}
