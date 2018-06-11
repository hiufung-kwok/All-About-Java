package com.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;


/**
 * Again it's a wrapper on top of BufferedReader, which provide a 
 * break down the token by delimitor which is identical to 
 * read line by line then break it down by String.split( )???
 *
 */
public class TokenScanner {

	public static void main(String[] args) {
		
		final String fname = "./resources/tokenfile.txt";
		
		
		try (Scanner s = new Scanner(new BufferedReader(new FileReader(fname)))){
		
			s.useLocale(Locale.CHINESE);
			//Can specify delimiter by s.useDelimiter(",");
			
			while(s.hasNext()) {
				System.out.println("Token: " + s.next());
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
