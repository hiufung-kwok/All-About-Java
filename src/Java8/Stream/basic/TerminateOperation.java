package Java8.Stream.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Java8.Stream.sample.Dish;
import Java8.Stream.sample.MenuFactory;

public class TerminateOperation {
	
	public static void main(String[] args) {

		ArrayList<Dish> menu = MenuFactory.getInstance();

		//By Index
		for (int i=0 ; i<menu.size() ; i++) {
			System.out.print(menu.get(i) + ", ");
		}
		System.out.println();
		
		
		//For-each
		for (Dish dish : menu) {
			System.out.print(dish+ ", ");
		}
		System.out.println();

		//For-each (Skip first 3 elements)
		int count = 0;
		for (Dish dish : menu) {
			count++;
			if (count >2) {
				System.out.print(dish + ", ");
			}
		}
		System.out.println();


		
		//Get Distinct
		//Compare by Equals( )
		List<Dish> newMenu = menu.stream().distinct().collect(Collectors.toList());	
		
		//Get first 3 by calories
		List<Dish> simplifiedMenu = menu.stream().limit(3).collect(Collectors.toList());
		
		//Discard first 3
		List<Dish> filteredMenu = menu.stream().skip(3).collect(Collectors.toList());
	
		
		
	}

}
