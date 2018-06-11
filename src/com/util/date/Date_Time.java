package com.util.date;

import java.util.Date;


/**
 * So troublesome for construct a Date, cuz its not intuitive at all. <br>
 * Luckily it's marked as suppress alr. <br><br>
 * <b>Remember that</b>:  Month start from zero 0 for Jan and Yr start from 1900.
 * 
 */
public class Date_Time {
	//Looking for 
	//Date date  = new Date(2017,12,15,20,30);
	//But end up like this:
	int year = 2017-1900;
	int month = 12-1;
	@SuppressWarnings("deprecation")
	Date date = new Date (year, month,25,20,30);

}
