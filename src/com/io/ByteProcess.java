package com.io;

import java.io.FileInputStream;

/**
 * Following example show how to read content from file by byte and 
 * render it out as a txt file.
 * 
 * Ref: https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
 * 
 * Noted that:
 * - Try with resources are in used.
 * - It read byte by byte, so dun expect word other than ascii would work.
 * Cuz it generally toke > 1 byte to store word. 
 * (EX: big5 -> double bytes, UTF-8 -> 1-4 bytes)
 * 
 * @author andykwok
 *
 */
public class ByteProcess {
	
	public static void main(String[] args) {
		final String inputFile = "./resources/bytefile.txt";
		//Output is exact the same thing, write instead of read.
		//final String outputFile = "outByteFile.txt";
		
		//Open up file stream
		try(FileInputStream fin = new FileInputStream(inputFile)) {
			
			int data = 0;
			StringBuilder sbt = new StringBuilder();
			
			//Read byte by byte
			while ( (data = fin.read()) != -1) {
				//Cast back to human readable
				sbt.append((char)data);
			}
			
			//Print out result
			System.out.println(sbt.toString());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	
}
