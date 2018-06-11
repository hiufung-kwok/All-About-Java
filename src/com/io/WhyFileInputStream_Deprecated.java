package com.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/*

 */

/**
 * This short demo would show how to call Files.newInputStream for ordinary file I/O operation
 * Instead of conventional FileInputStream method, in order to avoid the performance cost of 
 * Finalize () which implemented on FileInputStream class.
 * 
 * 
 * As you may wonder how does this oepration help to achieve high performance. 
 * It turn out that as FileOutputStream used, brand new object created along with the finalize method.
 * And the object only be cleaned up on next GC operation. It would cuase problem for some long-life / daemon app.
 * Because the resources would be occuptied till next GC and take computing power to destroy it. 
 * 
 * Ref: https://dzone.com/articles/fileinputstream-fileoutputstream-considered-harmful?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 */
public class WhyFileInputStream_Deprecated {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String test = "Testing";
		byte[] content = test.getBytes();
		oldWrite(content, "./test.txt");
		newWrite(content, "./test2.txt");
	}
	
	
	public static void oldWrite (byte[] content, String fileName ) throws FileNotFoundException, IOException {
		
		try (FileOutputStream fout = new FileOutputStream((fileName)) ) {
			fout.write(content);
		}
	}
	
	public static void newWrite (byte[] content, String fileName ) throws IOException  {
		try ( OutputStream os = Files.newOutputStream(Paths.get(fileName) ) ) {
	        os.write(content);
	    }
	}
	


}
