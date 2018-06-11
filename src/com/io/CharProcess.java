package com.io;

import java.io.FileReader;


/**
 * It similar to ByteProcess example, but this FileReader is used,
 * rather than FileInputStream. FileReader is a wrapper of it.
 * By seating on top of it, capable to handle translation from byte to char.
 * But in this example which make not different cuz int used as a container.
 */
public class CharProcess {

	public static void main(String[] args) {
		final String fname = "./resources/charFile.txt";
		//FileWriter
		try (FileReader fin = new FileReader(fname)) {
			
			int data;
			StringBuilder sbt = new StringBuilder();
			
			while( (data = fin.read())!= -1 ) {
				sbt.append((char)data);
			}
			
			System.out.println( sbt.toString() );
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
