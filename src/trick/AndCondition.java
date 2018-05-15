package trick;
/*
 * Following class take two boolean method call for evaluation and only proceed
 * to inside of IF clause when both expression satisfied. 
 * 
 * 
 * The trick here is JVM would skip to proceed further (2nd condition) when the 
 * first one not even match. Hence it would save resources by putting the method call 
 * inside of if ( ) instead of fetch the return result as boolean then check does it true or not.
 */
public class AndCondition {

	public static void main(String[] args) {
		
		
		System.out.println("------- First round -----------");
		boolean check1 = slow_verification(false);
		boolean check2 = heavy_crossChecking(false);
		//As all verification processed beforehand, crossChecking wasted,
		//cuz the result gonna be computed no matter verification valid or not.
		if (check1 && check2) {
			Computation();	
		}
		
	
		//In this case crossChecking won't be trigger if the preceding condition not even true.
		//Gonna be efficient if crosschecking is a expensive process.
		System.out.println("------- Second round -----------");
		if (slow_verification(false) && heavy_crossChecking(true) ) {
			Computation();	
		}
		
		
		
	}
	
	
	static private void Computation () {
		System.out.println("Computing result");
	}
	
	static private boolean slow_verification (boolean in_coming) {
		System.out.println("Vering.......");
		return in_coming;
	}
	
	static private boolean heavy_crossChecking (boolean in_coming) {
		System.out.println("Checking.......");
		return in_coming;
	}
	
}

