package fundamental;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;


/**
 * Ref: https://dzone.com/articles/arrayshashcode-vs-objectshash?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 */
public class HashCode {
	public static void main(String[] args) {

	   final Integer[] integers = IntStream.range(0, 999).boxed().toArray(Integer[]::new);
//		Arrays.hashCode(Object[]) would be same as Objects.hash( ) for reference type.
	   if (Arrays.hashCode(integers) == Objects.hash(integers)) {
		   System.out.println("equal for reference type");
	   }

//	   But not for primitive
	   final int[] ints = IntStream.range(0, 99).toArray();
	   if (Arrays.hashCode(ints) == Objects.hash(ints)) {
		   System.out.println("equal for primitive type");
	   }
		    
	}
}
