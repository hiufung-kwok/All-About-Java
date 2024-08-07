package com.system.out;


/**
 * 
 * Following class show how formatter can be used on all different situation. <br>
 * Also null won't crash the thing, just show "Null". <br>
 * <br>
 * Usage: 
 * <li>customize Log msg for JSP </li> 
 * 
 * <br>
 * Ref: https://dzone.com/articles/java-string-format-examples
 */
public class Formatter {
	
	
	
	
	
	public static void main(String[] args) {

		//Normal manual log case:
		String frame = "%s: Incoming Parameter missing<%s>";
		String jspName = "Hello_world.jsp";
		String para = "action";
		System.out.println(String.format(frame, jspName, para));
		
		//Null case -> Frame can't be null
		System.out.println(String.format(frame, jspName, null));
		
		
		//Math case:
		String fullStmt = "Today's account balances is: %.2f";
		double balance = 100.5;
		
		System.out.println(String.format(fullStmt, balance));
	}
}
