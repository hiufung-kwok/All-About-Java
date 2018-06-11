package com.lang.system;

import java.util.Map;



/**
 * Following code show how to access the environment, unlike C-like library <br>
 * System.getenv(); call hide all complexity behind so it work on all platform.<br>
 * <br>
 * getenv("String"); can used to return specific environment variable by name. <br>
 * 
 * @author Andyk
 *
 */
public class env_var {

	public static void main(String[] args) {
		
		
		//Fetch whole set of environment variables
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n",
					envName,
					env.get(envName));
		}

		//Or get specific one ?
		String env_var = System.getenv("Ha");
		
		
		
		
	}

}
