package jep.java8.Stream.advanced;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import jep.java8.Stream.sample.Dish;
import jep.java8.Stream.sample.MenuFactory;

public class Partitioning {
	public static void main(String[] args) {
		
		
		List<Dish> menu = MenuFactory.getInstance();
		
		//Most two different groups 
		//Ref: http://fahdshariff.blogspot.com/2015/11/java-8-streams-api-grouping-and.html
		Map<Boolean, List<Dish>> partitionedMenu = 
				menu.stream().collect(
						Collectors.partitioningBy(Dish::isVegetarian));
		
		for (Entry<Boolean, List<Dish>> entry : partitionedMenu.entrySet()) {
			System.out.println(entry.getKey());	
		}
		
		
		//By combining both group and paritiion, can produce two lv map.
		Map<Boolean, Map<Dish.Type, List<Dish> > > result;
		result = menu.stream()
						.collect(
							Collectors.partitioningBy(
									Dish::isVegetarian,
									Collectors.groupingBy(Dish::getType)));
		
		
				
	}
}
