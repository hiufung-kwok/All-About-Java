package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleFileIO {
	
	
	
	/**
	 *  - Remember to flush
	 *  - Intermedium class is Bytes (not String)
	 *  - As String is not used, no encoding. 
	 *  - No buffer (Stream - Read as demand)
	 *  - EOF byte is not guarantee 
	 *  - Mean to be used for binary file like: image
	 */
	private static boolean fileIOStream (String data, String f_name) {
		
		//Either file not found (FileNotFoundException) || Can't read or write (IOException)
		try (FileOutputStream fout = new FileOutputStream(f_name)) {
			//Take bytes as input, need to handle encoding issue
			//Would work mostly for English but not guarantee for others. 
			fout.write( data.getBytes() );
			
		} catch (IOException e) { System.err.println("Can't write to " + f_name);}
		
		
		try (FileInputStream fin = new FileInputStream(f_name)) {
			//String word = "Hello world";
			int word;
			char [] content = new char [data.length()];
			int count = 0;
			while ((word = fin.read()) != -1) {
				content[count] = (char)word;
				count++;
			}
			
			String result = new String (content);
			return data.equals(result);
		} catch (IOException e) { System.err.println("Can't read to " + f_name);}
		
		return false;	
	}

	/**
	 * Come into kick when single I/O operation is segment which is smaller than the buffer size.
	 * In this way stream object manage to do a bulk operation only when buffer is full house,
	 * which is ready to go. 
	 * 
	 *  - Warped ver of FileOutputStream
	 * @return
	 */
	private static boolean bufferStream (String data, String f_name) {
		
		//Either file not found (FileNotFoundException) || Can't read or write (IOException)
		try ( FileOutputStream fout = new FileOutputStream(f_name);
			  BufferedOutputStream bout = new BufferedOutputStream(fout)) {
			//Take bytes as input, need to handle encoding issue
			//Would work mostly for English but not guarantee for others. 
			bout.write( data.getBytes() );
			
		} catch (IOException e) { System.err.println("Can't write to " + f_name);}
		
		
		try (FileInputStream fin = new FileInputStream(f_name);
			 BufferedInputStream bin= new BufferedInputStream (fin);) {
			//String word = "Hello world";
			int word;
			char [] content = new char [data.length()];
			int count = 0;
			while ((word = bin.read()) != -1) {
				content[count] = (char)word;
				count++;
			}
			
			String result = new String (content);
			return data.equals(result);
		} catch (IOException e) { System.err.println("Can't read to " + f_name);}
		
		return false;	
		
	}

	/**
	 * Even though it take byte [] but, this is mean for text file IO. 
	 * Can think of FileWriter = FileOutputSTream +  ( txt -> bin conversion )
	 */
	private static boolean fileRW (String data, String f_name) {
		
		try (FileWriter fw = new FileWriter(f_name)) {
			fw.write(data);
		} catch (IOException e) { e.printStackTrace();}
		
		
		char [] content = new char [data.length()];
		try (FileReader fr = new FileReader(f_name)) {
			fr.read(content);
			return data.equals(new String(content));
		} catch  (IOException e) { e.printStackTrace(); }
		return false;
		
	}
	
	/**
	 * Buffered version of FileReader, but most importantly can read one whole line.
	 * Mean can be programming in more abstract mode , btye -> String
	 */
	private static boolean bufferFileRW (String data, String f_name) {

		try (FileWriter fw = new FileWriter(f_name);
				BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write(data);
		} catch (IOException e) { e.printStackTrace();}


		String content;
		try (FileReader fr = new FileReader(f_name);
				BufferedReader br = new BufferedReader(fr)) {
			content = br.readLine();
			return data.equals(content);
		} catch  (IOException e) { e.printStackTrace(); }
		return false;

	}
	
	
	/**
	 * Similar to FileWriter as both subclass of writer, however it doesn't throw exception
	 * so error only can check from checkError( ) call.
	 */
	private static boolean printRW (String data, String f_name) {
		
		try(PrintWriter pw = new PrintWriter(f_name);) {
			pw.write(data);
			return true;
		} catch (FileNotFoundException e) {	e.printStackTrace();}
		return false;
	}
	
	
	
	
	/**
	 * Following segment of code would write "Hello world"  in to text file and read it back
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//For binary
		//Obj -> OuputStream -> FileOUtputStream
		boolean fStream = fileIOStream("Hello world", "fileStream.txt");
		//Obj -> OutputStream -> FileOutputStream -> BuffferedOutputStream 
		boolean bStream = bufferStream("Hello world", "bufferStream.txt");
		
		//For text file 
		//Obj -> Reader -> InputStreamReader -> FileReader
		boolean wrer = fileRW("Hello world", "RWer.txt");
		//Obj -> Reader -> BufferedReader
		boolean bwrer = bufferFileRW("Hello world", "bufferedRW.txt");
		
		//Similar to bufferWriter but no exception thrown
		boolean printwer = printRW("Hello world", "bufferedRW.txt");
		
		System.out.println(fStream);
		System.out.println(bStream);
		System.out.println(wrer);
		System.out.println(printwer);
		
		
	}

}
