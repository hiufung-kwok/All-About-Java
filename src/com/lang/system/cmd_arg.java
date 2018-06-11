package com.lang.system;




/**
 * This segment of code used to demonstrate how argument can be retrieved  <br>
 * by reading String[] args. Remember that unlike C language, first argument <br>
 * really placed on the first position which is args[0] instead of [1]. <br>
 */
public class cmd_arg {

	public static void main(String[] args) {
		
		//Print all arg in one off
		for(String current: args) {
			System.out.println(current);
		}
		
		//Parse cmd_arg to int
		int int_arg;
		try {
			int_arg = Integer.parseInt("Apple");
		} catch (NumberFormatException e) {
			System.err.println("Parse int error!!!");
		}


	}

}
