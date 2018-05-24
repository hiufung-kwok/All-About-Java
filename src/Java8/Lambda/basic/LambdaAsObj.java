package Java8.Lambda.basic;

import java.util.function.Supplier;

public class LambdaAsObj {

	public static void main(String[] args) {
		
		//By Exist method which have same signature
		Supplier<String> str = String::new;
		//Specify it right away (Inline)
		Supplier<String> str_2 = () -> "Hello";
		
		//Supplier<Integer> invalidLambda = String::new;
		
	}
}
