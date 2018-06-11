package com.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Its a sub-set of DateFormat, which provide enough support for daily parsing use.
 * Output a String representation by given date and pre-set format.
 * 
 * Static.prase method is not thread-safe (Beaware).
 * 
 */
public class SimpleDate {
	
	public static void main(String[] args) {
		//Another topic for String format.
		Date date = new Date();
		//Aim to simply for date generation
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(date));
		
		//With time-zone on 
		df = new SimpleDateFormat ("ZZZZ");
		System.out.println(df.format(date));
		
		//Date with wek
		df = new SimpleDateFormat("yyyy-'W'ww-E");
		System.out.println(df.format(date));
		
		//Localize content
		df = new SimpleDateFormat("MMM",Locale.KOREAN);
		System.out.println(df.format(date) );

		
	}

}
