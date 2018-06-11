package Java8;



/*
 * Default method is introduced under Java8 release. It's such a thing for me when first learning about it. 
 * How can it be making any sense? Interface is a frame of a class, it provide a guideline when come to 
 * creating classes. By implementing any given interface, you are imply to provide definition of all method
 * mentioned on interface. Let's say every classes which implement auotcloseable would always have method call
 * close( ). They may have their own way to close( ), but all with the identitical signature. 
 * 
 * It's kind of make sense thou. Let say both Java.sql.connection && FileReader both implemented autocloseable. 
 * But as you may notice, code require to close a DB close is obvious distinct from close a file I/O connection
 * and by the time we first draft the interface autocloseable, we know nothing about the Childe classes. They
 * may used to close a DB connection, Socket connection or File I/O channel. Who knows?
 * 
 * So in this way, there is non sense of putting implementataion on Interface, cuz the context of method is base on 
 * the context of Child class. But you know what community actually got another thought. They are thinking: Oh it would 
 * be great if a common behavior can be defined on interface then all child classes implemented it would  simply run their 
 * class-specific code after the common-bit. Instead of copying the whole premise operation into all implemented class.
 * 
 * Let's say just so happen, Autocloseable need to proceed a common clean-up process as a preparation. The that peice of code
 * can just seat on Interface definition. Instead of copying to every implementation. 
 * 
 *  
 * However by having default definition of method. It introduce another problem which Java used to avoid. 
 * The diamond problem, which   
 * 
 *    
 *  
 * 
 * 
 */
public class DefaultMethod {

	public static interface A {
		default void hello () {
			System.out.println("Hello from A");
		}
	}
	
	public static interface B {
		default void hello () {
			System.out.println("Hello from B");
		}
	}
	

	//In this case, Interface A, B are on the same lv, so need to
	//Call super class explicitly for declaration 
	public static  class C implements A, B  {

		@Override
		public void hello() {
			A.super.hello();
		}
		
	}

	
	
	public static void main(String[] args) {
		C c = new C();
		c.hello();
	}

}
