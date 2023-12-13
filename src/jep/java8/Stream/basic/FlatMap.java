package jep.java8.Stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {
		
		/**
		 * This part of code demonstrate how to flatten a 2D Object structure into a pure Stream.
		 * Which would be useful when need to process data in a sequential matter. Of course, the old 
		 * trick work perfectly by writing a for loop to dump all Object into one giant loop. But data 
		 * need to be loaded to memory in one shot.
		 * 
		 * It's the big data era. Such approach would stuck as data grow. Just thrown a out of memory exception
		 * and you are done. 
		 */
		String[] tech = {"Atlassian", "Google", "Netflex"};
		String[] socialMedia = {"FB", "IG", "Twitter"};
		String[][] company = new String[][]{tech, socialMedia};
		 
		 //2D -> 1D -> Flat Stream
		 //String [][] -> <String[]> Stream<String[]>  -> <String> Stream<String> -> Stream<String>
		 Stream<String> streamOfwords = Arrays
				 .stream(company)
				 //String[] -> Stream<String>
				 .flatMap(x -> Arrays.stream(x) );
		 //A pretty flat String stream
		 streamOfwords.forEach(System.out::println);
		 
		
		 /**
		  * Not flatMap related, more to a review of Map feature 
		  */
		//Filter like things?
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		//Normal mapping 
		List<Integer> num = numbers.stream()
				.map(x -> x*x)
				.collect(Collectors.toList());
		num.stream().forEach(System.out::println);
		
		System.out.println();
		
		
		/**
		 * Construct a Cartesian product stream by two Integer List
		 */
		//Resemble -> List*2 to List<int[]>
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(3,4);
		//Nested loop
		List<int[]>pairs = 
				numbers1.stream()
						//Where the magic happen, produce a int[] for result, which is not flat obviously.
						.flatMap(i -> numbers2.stream().map(j-> new int[] {i, j}))
						.collect(Collectors.toList());
		
		for (int[]pair: pairs) {
			for (int item : pair) {
				System.out.print(item+",");
			}
			System.out.println();
		}
		
		

	}
}
