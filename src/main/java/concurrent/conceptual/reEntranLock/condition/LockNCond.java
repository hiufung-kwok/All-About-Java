package concurrent.conceptual.reEntranLock.condition;

import java.util.ArrayList;
import java.util.List;

/**
 * Its true that lock work identical as keyword Synchronized. 
 * So if the situation u fall in dun require condition usage,
 * Then simply pick synchronized, it would make ur life easier. 
 * 
 * 
 * Take away:
 *  - Fairness of reentranlock certainly affect performance for ~3x.
 *  - Too much worker thread would drag down the performance as busy switching. 
 */
public class LockNCond {


	private static class Producer implements Runnable {

		private String id;
		private Buffer buffer;
		private int target;
		private boolean stop = false;

		
		//Responsible to produce payload to buffer 50000 msg in total
		public Producer(String id, Buffer buffer, int  target) {
			super();
			this.target = target;
			this.id = id;
			this.buffer = buffer;
		}

		@Override
		public void run() {
			for (int inner = 1 ; inner <=target && !stop ; inner++) {
				try {
					String data = "payload<" + inner + ">";
				
					buffer.deposit(data);
					
					if (inner %10000 == 0) {
						System.out.println("Producer(" + id + "), putting data:" + data);
					}

				} catch (InterruptedException e) { 
					System.err.println("Got interrup while producing, stop prodcuer"); 
					stop = true;
				}
			}
		}

	}

	//Responsible to consumer msg from buffer, would continue to continue to consume it hit the limit (100000). 
	private static class Consumer implements Runnable {

		private String id;
		private Buffer buffer;


		public Consumer(String id, Buffer buffer) {
			super();
			this.id = id;
			this.buffer = buffer;
		}

		//Consume 1000000 msg at most.
		@Override
		public void run() {

			for (int i=0 ; i<1000000 ; i++) {
				
				try {
					String data = buffer.fetch();
					if (i%10000 == 0) {
						System.out.println(" - - Consumer(" + id + "), having data:" + data);
					}
				} catch (InterruptedException e) {
					System.err.println("Consumer(" + id + ") got interrupted");
					break;
				}
			}	
		}
	}

	/**
	 * Having the situation that buffer have capacity of 100,
	 * producer would continue to fill up the buffer for 50000 msg.
	 * And 20 worker would keep pop data from buffer will I got interrupt || hit it limit 100000.
	 * 
	 * Noted that, program only allow to run for 11s, when time out main thread would send interupted
	 * signal both producer && consumer to notice them to terminate.
	 * @param args
	 */
	public static void main(String[] args) {

		
		Buffer buffer = new Buffer(1000000);
		
		//20 consumer
		List<Thread> consumers = new ArrayList<Thread>();

		for (int i=0 ; i<20 ; i++) {
			Consumer customer = new Consumer(String.valueOf(i), buffer);
			Thread thread = new Thread(customer);
			consumers.add(thread);
			thread.start();
		}

		Producer prod = new Producer("1", buffer, 5000000);
		Thread thread = new Thread(prod);
		thread.start();

		try {
			Thread.sleep(5000);

			thread.interrupt();
			//Told consumer to terminate
			for (Thread consumer : consumers) {
				consumer.interrupt();
			}
			
			System.out.println("Join back");
			//Terminate all consumer
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}



}
