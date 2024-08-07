package com.util.date;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
//Ref: https://dzone.com/articles/using-timer-class-to-schedule-tasks


/**
 * Quick way to schedule a task run periodically. For more advanced usage, plz consult 
 * Executor || Thread pool 
 */
public class SampleTimer  extends TimerTask{

	public static void main(String[] args) {
		//Run straightway 
		Timer timer = new Timer();
		
		//exe 5s after (One off)
		timer.schedule(new SampleTimer(), new Date(new Date().getTime() + 5000));
		//Run every 5s
		//timer.schedule(new SampleTimer(), 0, 5000);
		
		//With delay (Start after 1s and repeat every 0.5s)
		timer.schedule(new SampleTimer(), 1000, 500);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " executing [" +  new Date() + "]");
	}
	

	
}
