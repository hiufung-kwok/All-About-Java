package com.bookref.effectiveJava.basic;


/**
 * Stuff like Java.math are such, just a group of related method. No need 
 * to instancelise beforehand. By making default constructor private
 */
public class StaticClass {
	
//	it prevent the default constructor got called.
	private StaticClass() {
		
	}

}
