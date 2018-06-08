package com.util.logging;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


/**
 * A short example of how to make use Stock logger. Which is simple to use for small scale project. 
 */
public class SimpleLogger {
	
	//Logger instance can be use straight away out of box.
	private final static java.util.logging.Logger logger = Logger.getLogger(SimpleLogger.class.getSimpleName());
	
	/**
	 * Also filter can be added if have special need. 
	 */
	private static void loggerConfig () {
		/*
		 * By dfault would go console sysout || syserr?
		 * As Eclipse show the word "INFO: Hello info"
		 */
		logger.info("Hello info");
		
		/* Set file handler which would redirect log into specific file.
		 * Configure the file name to be yyyy-MMM.log format
		 */
		String date =  new SimpleDateFormat("yyyy-MMM").format(System.currentTimeMillis());
		try {
			//True for append > overwrite 
			FileHandler fh = new FileHandler("./" + date + ".log", true);
			//Logger -> Handler -> Formatter
			fh.setFormatter( new SimpleFormatter());
			logger.addHandler(fh);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}	
	}
	
	private static void loggerUsage() {
		//Different level (low -> high)
		logger.finest("Hello Finest");
		logger.finer("Hello Finer");
		logger.fine("Hello fine");
		logger.config("Hello config");
		logger.info("Hello info");
		logger.warning("Hello warning");
		logger.severe("Hello severe");
	}
	
	public static void main(String[] args) {
		loggerConfig();
		loggerUsage();
	}

	

}
