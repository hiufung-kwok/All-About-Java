package jep.java8.Lambda.implementation;

import java.util.function.Function;

public class FunctionComposition {
	public static void main(String[] args) {

		//Group multiple function interface into one
		Function<Integer, Integer> addition = x-> x+1;
		Function<Integer, Integer> multiplication = x-> x*2;
		
		//Normal way
		System.out.println("Result: " + multiplication.apply(addition.apply(10) ) );
		//Chain Function
		Function<Integer, Integer> equation =  addition.andThen(multiplication);
		//Identical to 
		Function<Integer, Integer> equation_2 =  multiplication.compose(addition);
		
		
		//Function come with apply
		System.out.println("Result: " + equation.apply(10));
		System.out.println("Result: " + equation_2.apply(10));
	}
}
