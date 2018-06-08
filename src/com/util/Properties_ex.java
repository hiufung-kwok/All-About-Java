package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*Demonstrate  how console application utilize Properties class
 *  for saving user preference when security manager is absent.  
 */

/**
 * Quick way to persist data (App based)
 *  - Seriaolize
 * Popular
 * 	- Wrap by other framework
 * File to exposed for configuration where Jar is packed
 * 
 * 
 */

/**
 * Properties, tit's something that may sound tedious at first and you may start question how much such class, 
 * who the heck in the world would use it bababab, all until discover it's beauty and how much it can do for 
 * you to save while drafting your demo application. 
 * 
 * The main usage of properties class is used to store application configuration in one place and the most 
 * awesome in here is properties would take care of the tedious I/O process, all you need  supply a co-response
 * i/o stream then properties would know exactly how to store data on file and known exactly how to retrieve it
 * when need to.  
 * 
 * 
 */
public class Properties_ex {

	
	public static void main(String[] args) {
		
		Properties Props ;
		//Construct new empty properties class
		Props = new Properties();
		
		//Only read if the file exist
		
		try (FileInputStream in = new FileInputStream("./configure.txt")) {
			//Read data
			Props.load(in);
			in.close();
		}  catch (IOException e1) {
			System.out.println("File not exist!");
		}
		
			
		//Processing (String pair)
		Props.setProperty("Server_address", "127.0.0.1");
		Props.setProperty("Secret", "password");
		
		//Contain && get
		if(Props.contains("Server_address")) {
			String host;
			host = Props.getProperty("Server_host");
			System.out.println("Host address: " + host);
		}

	
		//Remove
		Props.remove("Secret");

		//List print Element pairs into given stream
		Props.list(System.out);
		
		
		//String Property Names
		System.out.println("What inside: " + Props.stringPropertyNames() );
		
		//How many pari at the moment
		System.out.println("Number of key pair: " + Props.size() );
		
			
		
		
		//Finish up, save whatever it have
		try {
			FileOutputStream out;
			out = new FileOutputStream("./configure.txt");
			//Comment string at the top of the output
			Props.store(out, "---No Comment---");
			
		} catch (IOException e) {
			System.out.println("Having problem with save preference!");
			e.printStackTrace();
		}
		
		
		
		//Java runtime use properties to maintain it configuration as well.
		System.out.println(System.getProperty("user.dir"));
		
		
	

	}

}
