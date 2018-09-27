package com.bookref.effectiveJava.classAndInterfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * This class demonstrate how inheritance would be abused,
 * hence it function not as expected. 
 * 
 * Best practice would be mark it as final class if not intended to extend by any classes.
 * @param <V>
 */
public class WronglyInheritance<V> extends HashSet<V> {
	
	private int count;
	
	
	public WronglyInheritance() {
		super();
		count = 0;
	}
	
	/**
	 * Override org method to provide count freature. 
	 */
	@Override
	public boolean add(V e) {
		System.out.println("Add one ");
		count++;
		return super.add(e);
	}


	@Override
	public boolean addAll(Collection<? extends V> c) {
		System.out.println("Add all: ");
		count++;
		return super.addAll(c);
	}


	/**
	 * Getter for count.
	 * @return
	 */
	public int getCount() {
		return count;
	}





	public static void main(String[] args) {
		WronglyInheritance<String> list = new WronglyInheritance();
		
		ArrayList<String> content = new ArrayList<String>();
		content.add("apple");
		
		list.addAll(content);
		/**
		 * It would be count twice for every item, as super.addAll is call
		 * .add( ) for every item from the incoming collection.
		 */
		System.out.println(list.getCount());
	}
}
