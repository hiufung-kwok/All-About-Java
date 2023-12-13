package jep.java8.Stream.sample;

import java.util.ArrayList;

public class MenuFactory {
	
	public static ArrayList<Dish> getInstance () {
		
		
		ArrayList<Dish> menu = new ArrayList<Dish>();

		menu.add(new Dish("pork", false, 800, Dish.Type.MEAT) );
		menu.add(new Dish("beef", false, 700, Dish.Type.MEAT));
		menu.add(new Dish("chicken", false, 400, Dish.Type.MEAT));
		menu.add(new Dish("french fries", true, 530, Dish.Type.OTHER));
		menu.add(new Dish("rice", true, 350, Dish.Type.OTHER));
		menu.add(new Dish("season fruit", true, 120, Dish.Type.OTHER));
		menu.add(new Dish("pizza", true, 550, Dish.Type.OTHER));
		menu.add(new Dish("prawns", false, 300, Dish.Type.FISH));
		menu.add(new Dish("salmon", false, 450, Dish.Type.FISH) );
		menu.add(new Dish("salmon", false, 450, Dish.Type.FISH) );

		return menu;

		
	}

}
