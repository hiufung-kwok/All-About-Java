package fundamental.enum_sample;

import java.util.HashMap;
import java.util.Map;

public class lookup {

	//Basic hello world example
	public enum DayOfWeek {
		Mon, Tue, Wed, Thu, Fri, Sat, Sun;
	}
	//Complex one with multiple field
	public enum Employment {
		PartTime("$34"),
		Causal("$50"),
		FullTime("$13000");
		
		private String wage;
		
		Employment (String wage) {
			this.wage = wage;
		}
		
		//Getter 
		public String wage() {
			return wage;
		}
	}
	
	
	public static void main(String[] args) {
		//Following method should be deprecated.
		
		/* Following way is most popular way for beginner to look up Enum type. 
		 * However exception would thrown once no match found. 
		 * 
		 * It become problematic in several aspect.
		 * 
		 *  - Exception expensive
		 *  
		 *  - IllegalArgumentException is ambiguous for a Enum lookup failure.
		 *  
		 *  - Your damn program is not crash, not need a exception to show its failure,
		 *  its not a programming fault && error at all. Simply response a error msg to 
		 *  user to notice input is invalid then is ok.
		 * 
		 */
		try {
		Employment ppl = Employment.valueOf("No");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Hence one of the approach is stored a whole collection in a static and lookup every time I needed to. 
		 */
		
		Map<String, Employment> collection = new HashMap<String, Employment>();
		for (Employment type : Employment.values() ) {
			collection.put(type.wage, type);
		}
		
		//All look can be done by map afterward
		Employment staff = collection.get("$34");
		if (staff != null) {
			System.out.println("Found it");
		}else {
			System.out.println("No exist");
		}
		
		
		
	}
	
	
	
	
	
}
