package fundamental.enum_sample;

public class enum_example {

	public enum season {
		spring,
		summer,
		autumn,
		winter
	}
	
	/* About enum
	 * 
	 * Yes, it's true to use final int to have slightly ~1.5% of performance boost,
	 * however it make code so hard to maintain as more line need to represent fragment
	 * meaning. So say yes to int unless performance testing show Enum is the bottleneck.
	 * 
	 * Ref: http://stackoverflow.com/questions/8029040/performance-of-java-enums
	 * 
	 * Why use Enum?
	 * 
	 *  - Security issue, while setter is on fr public access, no check is needed,
	 *  cuz only value in range allowed.
	 *  
	 *  - Readability, not doubt with that.
	 */
	public static void main(String[] args) {
		
		//Enum with four type {Spring, Summer, Autumn, Winter} Respectively  
		season current = season.winter;
		
		System.out.println("What season is it?  " + current);
		
		//Equality 
		System.out.println("Is it winter now? " + current.equals(season.winter) );
		
		
		
		

	}

}
