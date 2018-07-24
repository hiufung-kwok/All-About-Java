package src.fundamental.numericalBound;

public class INT {
	public static void main(String[] args) {
		int max = 2147483647;
		//Should be zero instead cuz out bound.
		//2^31 last bit for signed
		System.out.println(max+1);
	}
}
