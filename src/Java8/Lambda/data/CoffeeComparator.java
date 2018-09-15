package Java8.Lambda.data;

import java.util.Comparator;

public class CoffeeComparator implements Comparator<Coffee> {

	public int compare(Coffee arg0, Coffee arg1) {
		return (int) (arg0.getPrice() - arg1.getPrice());
	}
}
