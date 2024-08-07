package jep.java8.Lambda.basic;

import java.util.ArrayList;
import java.util.Comparator;

import jep.java8.Lambda.data.Coffee;
import jep.java8.Lambda.data.CoffeeComparator;

/**
 * Different type of coffee sale on Maccas, sorted by price. <br>
 * Its perfect example for show how sorting method can be<br>
 * write int more compact than existing!<br>
 *
 */
public class ComparationOnLambda {

	
	public static void main(String[] args) {
	
		ArrayList<Coffee> store = new ArrayList<Coffee>();
		store.add(new Coffee(3.3, "Cap"));
		store.add(new Coffee(2.0, "Long black"));
		store.add(new Coffee(5.5, "Breekie"));
		
		//Old way
		store.sort(new CoffeeComparator());
		
		//In-line style
		store.sort(new Comparator<Coffee> () {
			@Override
			public int compare(Coffee o1, Coffee o2) {
				return (int) (o1.getPrice() - o2.getPrice());		
			}
		});
		
		
		//Lambda 
		store.sort((Coffee o1, Coffee o2) 
				-> (int) (o1.getPrice() - o2.getPrice()) );
		
		
		
		//Lambda with Comparator interface 
		Comparator<Coffee> comparator = Comparator.comparing((Coffee c) -> c.getPrice() );
		store.sort(comparator);
		
		//More further packed
		store.sort(Comparator.comparing((Coffee c) -> c.getPrice() ) );
		
		//Best can do
		store.sort(Comparator.comparing(Coffee::getPrice));
		
		//Reverse order
		store.sort(Comparator.comparing(Coffee::getPrice).reversed());
		
		//Chain comparator
		store.sort(Comparator.comparing(Coffee::getPrice)
				.reversed()
				.thenComparing(Coffee::getName) );
		
	}


}
