package com.bookref.effectiveJava.classAndInterfaces;

import com.bookref.effectiveJava.classAndInterfaces.base.Accessable;



/**
 * As parent class Accessable have implement autocloseable,
 * SubClass have it by default.
 */
public class SubClass extends Accessable{

	
	/**
	 * a is not accessible even from sub-class which extended it from. 
	 */
	private void accessA () {
//		this.a;
//		via getter
		System.out.println(this.getA());
		System.out.println(this.getB());
	}
	
	
	 public static void main(String[] args) {
		SubClass s = new SubClass();
//		a can't it's private, b can't it's differ package.
		System.out.printf("[%s, %s]\n", s.c, s.d);
		if (s instanceof AutoCloseable) {
			System.out.println("i am a auto-closeable");
		}
	}
	 
	 
	 
}
