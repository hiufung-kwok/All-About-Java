package com.util.concurrency.conceptual.Deadlock;

/*
 * Following package is trying present you how deadlock can happen when 
 * ReentrantLock is handled in a proper manner. 
 * 
 * In this example two threads are interacting with two a/c 
 * for transfer money concurrently, when the initial approach implemented.
 * It may happen that each thread kept one lock each and both of them
 * wait to obtain to other one. Hence they are waiting each other, till one 
 * gave up, but it wouldn't happen. 
 * 
 * So the better the approach is try to obtain lock and only proceed when
 * both lock obtain, either one lock fail would lead to release of 
 * the existing lock. 
 * 
 *  May cause more resources to dealt the such situation, at least it work?
 */
public class App {

	public static void main(String[] args) throws InterruptedException {
		final Runner runner = new Runner();
		
		Thread t1 = new Thread (new Runnable()  {
			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch( InterruptedException e) {

					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread (new Runnable()  {
			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch( InterruptedException e) {

					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		runner.finished();
	}

}
