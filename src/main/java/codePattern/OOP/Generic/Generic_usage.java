package codePattern.OOP.Generic;

public class Generic_usage {
	
	

	public static void main(String[] args) {
		
		//They all functioning on the same way as Object is the root type in root.
		Generic_Container <String, String> gen = new Generic_Container <String, String> ("Mac air ", "$8999HKD");
		Object_Container obj = new Object_Container ("Mac pro ", "$19999HKD");
		
		gen.print();
		obj.print();
		
		/*Can swap type in run-time for Object method 
		 * cuz all object in Java world inherent from object class
		 * 
		 */
		obj.setValue((Integer)18000);
		obj.print();
		
		/* However the same thing is allow on generic 
		 * since the type is declared while it first construct.
		 * you just can't do something like this:  gen.setValue((Integer)18000);
		 * As incoming type is different from the promise type (String). 
		 */
		
		/* The other problem arise as if incoming type is supported by the method 
		 * on the container ClassCastException would occur.
	 	 * It work even price change to int type, as long as it support print method.
		 *
		 */
		Generic_Container <String, Integer> iphone = new Generic_Container <String, Integer> ("IPhone ",  6900);
		
		iphone.print();
		

	}

}
