package jep.java8.Stream.sample;

public class Dish {
	
	public enum Type { MEAT, FISH, OTHER }
	
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	
	

	public boolean isVegetarian() {
		return vegetarian;
	}


	public int getCalories() {
		return calories;
	}


	public Type getType() {
		return type;
	}


	public int getcalories() {
		return calories;
	}

	
	public String getName() {
		return name;
	}

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
		}


	@Override
	public String toString() {
		return this.name;
	}
	
	
	

}
