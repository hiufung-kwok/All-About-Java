package com.io;

import java.io.Console;
import java.util.Arrays;

/**
 * Demonstrate how to use console, which is dffer from System.in || out
 *  
 *  - Not work on IDE like: Eclipse
 */
public class ConsolePw {
	public static void main(String[] args) {
		Console c = System.console();
		
		if (c ==null) {
			String warn = "Console is not available (%tc)";
			System.out.println(String.format(warn, System.currentTimeMillis()));
		}
		
		String usr = c.readLine("username: ");
		char [] pw = c.readPassword("Password: ");
		
		System.out.format("[%s | %s ]", usr, pw);
		
		//Remember to wipe pw
		Arrays.fill(pw, ' ');
		
		
		
		
		
	}
}
