package Java8.Lambda.basic;


public class Basic {
	
	public static void main(String[] args) {

		simpleLamabda();
		//StringProcessor pro = new StringProcessor();
		StringProcessor strProcessor = (String str) -> "Prefix:::::::::" + str;
		printString(strProcessor);
		strProcessor = (String str) ->str + "::::::::Postfix";
		printString(strProcessor);
		
	}
	
	@FunctionalInterface
	public interface StringProcessor {
		String process(String str);
	}

	
	public static void printString (StringProcessor p) {
		System.out.println("Start:....");
		System.out.println(p.process("Hello World"));
		System.out.println("End......");
	}
	
	
	/**
	 * Following method can be seen as a earlier version of functional programming.<br>
	 * Method call process take a Runnable object then trigger it run method call with in the object.<br>
	 * <br>
	 * And here show how the Runnable can be various way
	 * <ul>
	 * 	<li>Lambda</li>
	 *  <li>Old way </li>
	 *  <li>In-line Lambda </li>
	 * </ul>
	 * 
	 * 
	 */
	private static void simpleLamabda () {
		
		//By Anonymous class (Old way)
		Runnable r1 = new Runnable () {
			public void run () {
				 System.out.println("Hello World ");
			}
		};
		
		//By Lambda
		Runnable r2 = () -> System.out.println("Hello World 2");
		
		process(r1);
		process(r2);
		process( () -> System.out.println("Hello World 3") );
	}
	
	
	/**
	 * Expecting a runnable <b>interface</b>, then trigger the run( ); 
	 * @param r
	 */
	private static void process (Runnable r) {
		r.run();
	}
	
	
	
	

}

