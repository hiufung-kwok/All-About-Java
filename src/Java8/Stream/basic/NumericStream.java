package Java8.Stream.basic;

import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Java8.Stream.sample.Dish;
import Java8.Stream.sample.MenuFactory;

/**
 * All stat result like sum, min, max, bababa......
 * 
 * Why bother when stock interface come with it?
 */
public class NumericStream {

	public static void main(String[] args) {
		
		ArrayList<Dish> menu = MenuFactory.getInstance();
		
		int tmpt = 0;
		
		//Total sum of calories on menu (simple way)
		int totalCalories = menu.stream()
							.map(Dish::getCalories)
							.reduce(tmpt, Integer::sum);
		
		
		/*
		 * Turn out its more efficient to call sum instead of do it by ur self.
		 * The trick here is first map to Int then sum();
		 * The point here as a se aware what we doing, passing a Integer stream along,
		 * but preceeding method ( ) dun expect that, it's not point sum of array of Dishes right?
		 * Only make sense when encounter certain type.
		 * That's why sum only showup when mapToInt( )
		 */
		
		IntStream caloriesStream = menu.stream().mapToInt(Dish::getCalories);
		
		totalCalories = caloriesStream.sum();
		System.out.println("Total calories of menu: " + totalCalories);
		
		//Convert back to Stream<Integer>
		//Stream<Integer> stream = caloriesStream.boxed();
		
		//OPtional is used to determine zero situation. can't be calculate or actually equal to zero?
		OptionalInt maxCalories = menu.stream()
									.mapToInt(Dish::getCalories)
									.max();
		if (maxCalories.isPresent()) {
			System.out.println("Max cal food on menu: " + maxCalories.getAsInt());
		}

		
		
	}
}
