package jep.java8.Stream.basic;

import java.util.ArrayList;
import java.util.Optional;

import jep.java8.Stream.sample.Dish;
import jep.java8.Stream.sample.MenuFactory;

public class Reduce {

	public static void main(String[] args) {
		
		ArrayList<Dish> menu = MenuFactory.getInstance();
		
		long total = menu.stream()
				.count();
		
		System.out.println(total);
		
		int result = 0;
		
		//Stream way of counting (tedious???)
		int count = menu.stream()
						.map(d -> 1)
						.reduce(result, Integer::sum );
		
		System.out.println(count);
		
		//Find max cal 
		Optional<Integer> mx = menu.stream()
									.map(x -> x.getCalories())
									.reduce(Integer::max);
		System.out.println("Max Cal: " + mx.get());
		

	}

}
