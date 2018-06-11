package com.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Src ref: https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
 * Path is just path, dun contain all info other than pointer, so need to 
 * check does file actually exist on run-time.
 *
 */
public class Path_test {
	public static void main(String[] args) {
		
		
		/**
		 * Again, path dun mean thee file actually exist
		 */
		Path path = Paths.get("includes/pkey/");
		
		//Several methods to obtain info from Path class
		//Get partial path by lv
		System.out.format("Lv0: %s\n", path.getName(0));
		System.out.format("Lv1: %s\n", path.getName(1));
		
		//Get just the file name
		System.out.format("File name: %s\n", path.getFileName());
		
		//Get absolute path
		System.out.format("Absolute path: %s\n", path.toAbsolutePath() );
		
		
		//Add file upon current path
		Path filePath = path.resolve("abc.jsp");
		System.out.format("Add file abc.jsp: %s\n", filePath.toAbsolutePath());
		
		//A file which is far far far away
		Path farAway = Paths.get("includes/skey/keystore/exchange/stp/gateway");
		System.out.format("How to get from A -> B: %s\n", path.relativize(farAway));
		System.out.format("How to get from B -> A: %s\n", farAway.relativize(path));
		//Kind of no point of compare how different is it. Either equal or not, just one word.
		System.out.format("Comparable: %s", farAway.compareTo(path) );
		
		
	}
}
