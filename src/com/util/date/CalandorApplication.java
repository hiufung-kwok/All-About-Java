package com.util.date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/**
 * Demonstrate how calendar can be used, should be consider as legacy API thou<br>
 * But widely used for decade alr, so its a must for professional Jav dev to<br>
 * understand how it work!<br>
 * <br>
 * Conclude all u need to know about calendar class.
 * <ul>
 * 	<li>Month start from 0 which is 0-11</li>
 * 	<li>To date is JVM local timezone</li>
 * 	<li>Avoid it when you can, counterintuitive</li>
 * </ul>
 * <br>
 * ref:<a href="https://www.mkyong.com/java/java-display-list-of-timezone-with-gmt"/> Table</a>
 */
public class CalandorApplication {
	
	public static void main(String[] args) {	
		timeZoneConversion();	
	}
	

	/**
	 * Zone to zone, convert time from zone to an other require two calendar to represent src / des time zone.
	 * Following zone demonstrate how its would do. Noted that such way should be used as Java8 having a 
	 * brand new set of API to perform such operation in so much simply way.
	 * 
	 * <br>
	 * Date is a relative concept, its meaningless when no timezone accompany. <br>
	 * Hence is Java Date class representing a moment without timezone. <br>
	 * So its meaningless of tolding me that 9:00 a.m. Ist sydney time? HKT? JPT? <br>
	 * Only be meaningful when developer assume certain time zone as default. <br>
	 * Which let say I have 9:00 a.m. in syd time which is GMT+10 <br>
	 * In order to convert it to Japan time, need to first output to millis by local time <br>
	 * Then feed into a calendar object which is jp time.
	 * 
	 * 
	 */
	public static void timeZoneConversion () {
		// Given a local time of 10am, get the time in Japan
		// Create a Calendar object with the local time zone
		Calendar local = new GregorianCalendar();
		local.set(Calendar.HOUR_OF_DAY, 10);               // 0..23
		local.set(Calendar.MINUTE, 0);
		local.set(Calendar.SECOND, 0);
		
		System.out.println(getTime(local));

		// Create an instance using Japan's time zone and set it with the local UTC
		Calendar japanCal = new GregorianCalendar(TimeZone.getTimeZone("Japan"));
		japanCal.setTimeInMillis(local.getTimeInMillis());
		
		//Only make different when query parameters one by one.
		System.out.println(getTime(japanCal));
		//While calling .getTime() would give back local time, cuz always print CST time.
		System.out.println(local.getTime());
		System.out.println(japanCal.getTime());


	}
	
	/**
	 * Construct calendar object with time-zone (GMT by default). <br>
	 * It work for all case which foreign -> local conversion. <br>
	 */
	public static void singleTimeZone () {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney") );
		//Set sydney time
		c.set(Calendar.HOUR_OF_DAY, 9);
		c.set(Calendar.MINUTE, 30); 
		//Syd -> HKT
		System.out.println(c.getTime());
		
		//JP -> HKT
		System.out.println(Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin")).getTime());
	}


	
	
	
	//Return a well formated string which represetn the time.
	public static String getTime (Calendar c) {
		// Get the foreign time
		int hour = c.get(Calendar.HOUR);            // 3
		int minutes = c.get(Calendar.MINUTE);       // 0
		int seconds = c.get(Calendar.SECOND);       // 0
		boolean am = c.get(Calendar.AM_PM) == Calendar.AM; //true
		
		return new String(hour + ":" + minutes  + ":" + seconds + " " + am);	

	}
}
