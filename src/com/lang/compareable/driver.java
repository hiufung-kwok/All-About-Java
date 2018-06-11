package com.lang.compareable;

import java.util.ArrayList;
import java.util.List;



/**
 * read more on Java8 Lambda section, 
 * how to write code in a more readable way.
 */
public class driver {

	public static void main(String[] args) {
		Lappy Mac_air = new Lappy ("Apple", 1000, 1.3);
		Lappy Ms_surface = new Lappy("Ms", 500, 1.1);
		
		//Which one should I get? (Always look for computing power first
		List<Lappy> list = new ArrayList <Lappy> ();
		
		list.add(Mac_air);
		list.add(Ms_surface);
		
		System.out.println("First item on the list (Before sort): " + list.get(0).getBrand() );
		
		list.sort(null);
		
		//Always surface, because it have lower computing power compare to Mac air
		System.out.println("After sort: " + list.get(0).getBrand() );
		

	}

}
