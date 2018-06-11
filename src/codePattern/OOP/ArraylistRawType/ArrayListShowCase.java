package codePattern.OOP.ArraylistRawType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
 * Original author:  Javin Paul 
 * Ref: http://javarevisited.blogspot.hk/2017/04/difference-between-raw-type-and-wild-card-arraylist.html
 */

public class ArrayListShowCase {

    public static void main(String args[]) {
        
        ArrayList<String> names = new ArrayList<String>();
        names.add("Java");
        
        //You can pass any type of ArrayList of to both methods
        printRawTypeList(names);
        printWildcardList(names);
    }
        
    
    /*
     * Java method which takes an ArrayList of raw types
     * and print elements on console, as type is not specify and 
     * parameterized either. Compiler won't do any checking and
     * let all operation just pass thou. 
     */
    public static void printRawTypeList(ArrayList rawType){
        for(Object obj : rawType){
            System.out.println(obj);
        }
        
        //Can perform insertion against any type.
        rawType.add(101); // OK
        rawType.add("101");  // OK
        rawType.add(121.00);  // OK
    }
    
    
    
    /*
     * As type is not specify, not insertion operation would be allowed,
     * Cuz it can't perform type check.
     * 
     * But that's its fine for output value as all class have Object as 
     * parent class. 
     */
    public static void printWildcardList(ArrayList<?> unbounded){
        
		 for (Object obj: unbounded) {
			 System.out.println(obj);
		 }
     
		   //    unbounded.add(101); // NOT OK
		   //     unbounded.add("101");  //  NOT OK
		   //    unbounded.add(121.00);  // NOT OK
	        
    }
   

}

