package com.lang.string;

import java.util.StringJoiner;

/* As StringJoiner is introduced in Java 8, 
 * here is some example of how u using it.
 */


public class String_Joiner_Ex {

	public static void main(String[] args) {
		
		//Can Simply call with delimiter set.
		StringJoiner str_j = new StringJoiner(",");
		
		//Add element add by add method
		str_j.add("Apple");
		str_j.add("Cat");
		//Then the output result should be like: Apple,Cat
		System.out.println(str_j.toString() );
		
		
		
		//Or set prefix && suffix
		StringJoiner str_j_complex =  new StringJoiner (",", "[", "]");
		
		//Add element
		str_j_complex.add("Apple");
		str_j_complex.add("Cat");
		//[Apple,Cat]
		System.out.println(str_j_complex.toString());
		
	}

}
