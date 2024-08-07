package jep.java8.Stream.basic;

import java.util.ArrayList;

import jep.java8.Stream.sample.Dish;
import jep.java8.Stream.sample.MenuFactory;


/**
 * Any match && none match are short circulate operation. 
 */
public class FindMatch {

	public static void main(String[] args) {
		
		ArrayList<Dish> menu = MenuFactory.getInstance();
		
		
		//Any Match section
		
		//Old 
		for (Dish dish : menu ) {
			if (dish.isVegetarian()) {
				System.out.println("Offer green dish!");
				break;
			}
		}
		
		//New
		if( menu.stream().anyMatch(Dish::isVegetarian) ){
			System.out.println("Offer green dish!");
		}

		
		
		//None Match section
	
		
		//Old 
		boolean lowCal = true;
		for (Dish dish : menu ) {
			if (dish.getcalories() >= 200) {
				lowCal = false;
			}
		}
		System.out.println( lowCal ?"Low cal food is not an option": "Welcome all!");
		
		//New
		if (menu.stream().noneMatch(x -> x.getCalories() < 200)) {
			System.out.println("Low cal food is not an option");
		}else {
			System.out.println("Welcome all!");
		}
			
		
		
		//All match?
		
		//Old
		boolean nonGreen = true;
		for (Dish dish : menu) {
			if (!dish.isVegetarian()) {
				nonGreen = false;
			}
		}
		System.out.println( nonGreen? "Nah, normal menu" : "It's green menu");
		
		
		//New
		if (menu.stream().allMatch(Dish::isVegetarian)) {
			System.out.println("It's green menu");
		}else {
			System.out.println("Nah, normal menu");
		}
		
	}

}
