package com.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * As this time BufferedReader is in used, it kept a buffer on its own.
 * So capable of doing io process by line.
 * 
 * Buffered reader have it own advantage:
 *  - More efficient, by cached content on RAM instead
 *  of real i/O process for every single time. 
 */
public class LIneProcess {

	
	public static void main(String[] args) {
		
		final String fname = "./resources/charFile.txt";
		
		try(BufferedReader fin = new BufferedReader(new FileReader(fname))) {
			
			String lineContent;
			
			while( (lineContent = fin.readLine()) != null ) {
				System.out.println("Line: " + lineContent);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
