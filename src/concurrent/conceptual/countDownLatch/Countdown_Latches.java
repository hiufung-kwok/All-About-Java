package concurrent.conceptual.countDownLatch;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Only launch when CountDownLatch count to 0.
 * One of the practical example is to wait for all services to be bootstrapped
 * completely before announcing it as healthy state to receive traffic.
 */
class Countdown_Latches_Processor implements Runnable {

	private CountDownLatch latch;
	
	public Countdown_Latches_Processor (CountDownLatch latch) {
		this.latch = latch;
	}
	
	
	@Override
	public void run() {
		System.out.println("Started.");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// It's a blocking call
		latch.countDown();
		System.out.println("Current count: " + latch.getCount());
		
	}
	
}



public class Countdown_Latches {
	
	public static void main (String[] args) {
		
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i=0 ; i<3 ; i++) {
			executor.submit(new Countdown_Latches_Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed");
		
		
	}

}
