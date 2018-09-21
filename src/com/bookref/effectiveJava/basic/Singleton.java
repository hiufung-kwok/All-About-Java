package com.bookref.effectiveJava.basic;

/**
 * Pro:
 *  - As object is created via static method, it give the flexibility if object
 *  need to be switch to spawn new instance upon every call.
 *  
 * Con:
 *  - Face difficulty when serialize
 *  
 */
public class Singleton {



	private static final Singleton INSTANCE = new Singleton();
	
	private Singleton() {
		super();
	}
	
	public Singleton getInstance() {
		return INSTANCE;
	}
	
	
}
