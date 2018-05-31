package Java8.Stream.advanced;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Java8.Stream.sample.Dish;
import Java8.Stream.sample.MenuFactory;

public class Collect {

	public static void main(String[] args) {

		List<Dish> menu = MenuFactory.getInstance();
		
		//All food name in one String
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
		
		System.out.println(shortMenu);
		
		//However its not readable at all. Better off to put comma between each entry.
		shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
		System.out.println(shortMenu);
		
		//Same result if Dish class equip to string method
		//shortMenu = menu.stream().collect(Collectors.joining());

		
		//Total Cal
		//Reducing == map( ) -> collect( )
		int totalCal = menu.stream().collect(Collectors.reducing(0,Dish::getCalories, (i,j) -> i+j));
		System.out.println("Total Cal: " + totalCal);
		
		//Appear to be the same, but above is clear. Do all in reducing.
		totalCal = menu.stream().map(Dish::getCalories).reduce(0, (i,j) -> i+j);
		System.out.println("Total Cal: " + totalCal);
		
		
		//Highest Cal
		Optional<Dish> mostCal = 
				menu.stream().collect(Collectors.reducing(
						(d1,d2) -> d1.getCalories() > d2.getCalories() ?d1:d2));
		
	}

}
