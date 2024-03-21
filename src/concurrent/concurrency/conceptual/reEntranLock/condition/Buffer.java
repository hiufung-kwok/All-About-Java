package concurrent.concurrency.conceptual.reEntranLock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Its a boundedBuffer which allow multiple thread access.
 * Notice thread when deposit && fetch available.
 * 
 * ref: https://dzone.com/articles/java-concurrency-%E2%80%93-part-5
 */
public class Buffer {

	//True for fairness which drop performance
	//private final Lock lock  = new ReentrantLock(true);
	private final Lock lock  = new ReentrantLock(false);
	/*
	 * Condition notice, keep a internal queue of threads which
	 * are waiting for access. Other threa would got notice when 
	 * current thread is done and call .signal(). 
	 */
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	private final String[] buffer;
	private final int capacity;

	private int front;
	private int rear;
	private int count;


	public Buffer (int capacity) {
		super();

		this.capacity = capacity;
		buffer = new String[capacity];
	}

	public void deposit(String data) throws InterruptedException {
		//Acquire lock
		lock.lock();

		try {
			//Await is blocking call, would wait till got signal if
			//occurred. 
			while (count == capacity) {
				notFull.await();
			}
			//Business logic
			buffer[rear] = data;
			rear = (rear + 1) % capacity;
			count++;
			//Current thread done, signal other thread (if any)
			notEmpty.signal();
			
		} finally {
			//Always put on final in-case got interrupted 
			lock.unlock();
		}
	}

	//Same thing as deposit but opposite
	public String fetch() throws InterruptedException {
		lock.lock();

		try {
			while (count == 0) {
				notEmpty.await();
			}

			String result = buffer[front];
			front = (front + 1) % capacity;
			count--;

			notFull.signal();

			return result;
		} finally {
			lock.unlock();
		}
	}

}

