package com.bookref.effectiveJava.basic;

import java.util.regex.Pattern;

/**
 * Train up your brain, immutable === cache-able
 *  - Dun be dumb, no point for implementing a object pool for lightweight object.
 *  As lookup pool would take time. Does it worth spend cost of 10 to compare hash and 
 *  lookup object, but instead only cost 5 to create a brand new object to use?
 */
public class ObjLifeCycle {
	
	private static final Pattern NUMBERONLY = Pattern.compile("[1-9]");
	
	public static void main(String[] args) {
		
/**
 * Using constructor for String obj would force JVM to create a brand new object to store Static.
 * However by simply assign the string literature, it would left room for JVM to decide and it only
 * create new instance when not exist yet.  
 */
//		Bad
		String s = new String ("Static");
//		Better
		String s2 = "Static";
		
//		The theory would work on immutable object like boolean as well. 
//		Bad
		Boolean b2 = new Boolean("true");
//		Good
		Boolean b = Boolean.valueOf("true");
		
//		The concept can go far beyond simple object creation 
		containNumberBad(s);
		containNumberGood(s);
		
		/**
		 * Also try to avoid auto-boxing when possible,
		 * 
		 */
		slowSum();
		quickSum();
	}
	
	
//	Pattern object would be created upon every String.matches invoke.
	private static boolean containNumberBad (String s) {
		    return s.matches("[1-9]");
	}
	
//	Better approach
	private static boolean containNumberGood (String s) {
		return NUMBERONLY.matcher(s).matches();
	}

	/**
	 * In this way for iteration int[i] would be first boxed into Integer,
	 * then addition is performed sum+=i;
	 * @return
	 */
	private static int slowSum() {

	    Integer sum = 0;
	    for (int i = 0; i <= 1000; i++) {
	    	 sum += i;
	    }
	    return sum;
	}
	
	/**
	 * Primitive stay primitive throughout the whole for loop.
	 * @return
	 */
	private static int quickSum () {
		int sum = 0;
		for (int i=0 ; i<=1000 ; i++) {
			sum +=i;
		}
		return sum;
	}

	
	/**
	 * Execution of finalize is totally depends on GC, so it would have different 
	 * behavior upon the type of JVM and GC. It's not guarantee. 
	 * 
	 *  - Never depends on it to update persistent state.
	 *  - Pick autocloseable when possible.
	 *  
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	

	
	
	
}
