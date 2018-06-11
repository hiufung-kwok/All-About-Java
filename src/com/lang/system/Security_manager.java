package com.lang.system;

public class Security_manager {

	public static void main(String[] args) {
		//Get a reference
		SecurityManager sec_manager = System.getSecurityManager();
		
		
		//Current thread have permission to exit?
		//sec_manager.checkExit(0);
		
		/*
		 * On applet if FileReader is present 
		 * then security exception will throw as 
		 * it dun allow i/o outside of the sandbox.
		 */
	}

}
