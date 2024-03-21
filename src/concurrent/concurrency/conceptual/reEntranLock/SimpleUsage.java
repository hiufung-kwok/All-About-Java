package concurrent.concurrency.conceptual.reEntranLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Following example simply used to demonstrate how a lock can be used in real world application.
 * In this example, customer class contain a ReentrantLock. Sclesman can only sale goods to customer,
 * when they successfully obtain the lock. 
 * 
 * So it mean only one sales can sale to one customer in one time. It make sense right?
 * And other salesman can't sale to the customer who reentrantLock is locked. 
 * 
 * In this First salesman try to sale Mac to Andy for first 3 seconds. And Acer sales try to sale 
 * acer laptop after 2s and ohho no luck cuz locked obtained by Apple sales.  
 */
public class SimpleUsage  {

	//Customer class
	private static class Customer {
		public String thing_to_buy;
		public Lock lock ;
		
		public Customer() {
			lock = new ReentrantLock();
		}
	}


	//Salesman which try to sale product to customer in given time
	// Who can hold customer for 3 seconds 
	static public class Salesman implements Runnable {

		private String product;
		private int time_to_start;
		private Customer customer;

		public Salesman (String brand, int time, Customer cus ) {

			product = brand;
			time_to_start = time;
			customer = cus;
		}

		@Override
		public void run() {
			try {
				//Only start sale at certain point of time
				Thread.sleep(time_to_start);
			} catch (Exception e) { }
			
			boolean locked = false;
			locked = customer.lock.tryLock();
				
			if (locked) {
				System.out.println(product + ": I have 3s to sale product");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) { e.printStackTrace(); }
				customer.lock.unlock();
			} else {
				System.out.println(product + " salesman: " + "Customer is busying at the moment;(" );
			}
			
			//Start to sale
			customer.thing_to_buy = product;
		}
	}


	//Main
    public static void main(String[] args) {
    	
    	Customer Andy = new Customer ();
    	Salesman Apple = new Salesman ("Apple Mac", 0, Andy);
    	Salesman Acer = new Salesman ("ACer lappy", 2000, Andy);
    	
    	new Thread (Apple).start();
    	new Thread (Acer).start();
    }
}




