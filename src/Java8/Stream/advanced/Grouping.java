package Java8.Stream.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import Java8.Stream.sample.Dish;
import Java8.Stream.sample.MenuFactory;

public class Grouping {


	public enum CaloricLevel { DIET, NORMAL, FAT }
	
	public static void main(String[] args) {
		
		
		List<Dish> menu = MenuFactory.getInstance();
		//New way
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				Collectors.groupingBy(dish -> {
					if (dish.getCalories() <= 400) 	return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700) return	CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				} ));
		
		
		//Old way
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel_old = new HashMap<CaloricLevel, List<Dish>> ();
		//Create all Level
		dishesByCaloricLevel_old.put( CaloricLevel.DIET, new ArrayList<Dish> () );
		dishesByCaloricLevel_old.put( CaloricLevel.NORMAL, new ArrayList<Dish> () );
		dishesByCaloricLevel_old.put( CaloricLevel.FAT, new ArrayList<Dish> () );
		for (Dish dish : menu) {
			if (dish.getCalories() <= 400) {
				dishesByCaloricLevel_old.get(CaloricLevel.DIET).add(dish);
			}else if (dish.getCalories() <= 700) {
				dishesByCaloricLevel_old.get(CaloricLevel.NORMAL).add(dish);
			}else {
				dishesByCaloricLevel_old.get(CaloricLevel.FAT).add(dish);
			}
		}
		
		
		
		//Grouping twice (n-level)
		//Rare to use, the container decoration gonna be freaking huge.
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel;
		dishesByTypeCaloricLevel = menu.stream().collect(
			Collectors.groupingBy(Dish::getType,
				Collectors.groupingBy(dish -> {
					if (dish.getCalories() <= 400) 	return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700) return	CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;}
				)
			)
		);
		
		
		Map<Dish.Type,Integer> totalCaloriesByType ;
		totalCaloriesByType =	menu.stream()
									.collect(
											Collectors.groupingBy(Dish::getType,
																	Collectors.summingInt(Dish::getCalories)));
				
		
		
	}
}
