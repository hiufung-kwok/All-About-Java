package Java8.Lambda.implementation;


// Mock functional interface 
interface Process {
	void process(int i);
}



public class Lambda_this_reference {

	
	//Run any incoming function with given int value
	public  void RunProcess (int i, Process p) {
		p.process(i);
	}
	
	
	/*Call RunProcess method with int 10 and 
	 *call to print msg. 
	 * 
	 */
	public void execute () {
		RunProcess (10, i-> {
			System.out.println("Values of i is " + i);
			System.out.println(this);
		});
	}
		
	/*A override method to indicate this method is 
	 * called within the instance (Class).
	 */
	public String toString() {
		return "Inside of a instance!";
	}
	
	
	public static void main(String[] args) {
		
		Lambda_this_reference lambda_this = new Lambda_this_reference();
		
		/* Execute method simply process RunProcess with lambda 
		 * function. It gonna print "Inside of a instance", because 
		 * lambda function run inside the class, so all "This" call 
		 * in call actually referring the class object. 
		 */
		lambda_this.execute();
		/* In here the program goona print something different from
		 * above, as lambda only defined outside of the class.
		 * So every time the code run, New Process object generated in
		 * run-time then pass it to RunProcess for execute. 
		 * 
		 * Hence the msg is not "Inside of a instance."
		 * 
		 */
		lambda_this.RunProcess(10, new Process () {

			public void process(int i) {
				System.out.println("Values of i is " + i);
				System.out.println(this);		
			}
			
		});
		
	}
	
	
	

}
