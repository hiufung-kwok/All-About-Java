package com.bookref.effectiveJava.basic;


/**
 * Static factory method are prefered in several way.
 *  - Contructor with same signature is not allowed, but Factory does.
 *  - Unlike constructor, not require to create a new object each time, make immu && cache possible
 *  - Able to return an object of any subtype but not it's self (Implementation).
 *  - Return object can bevary depends on input parameters. (Invisible to client)
 *  - Make service provider pattern workable(EG: JDBC)
 * 
 * Short coming:
 *  - Class without public or protected constructors cannot be subclassed.
 *  - Hard for programmers to find? (Doubt that)
 *  
 *  
 * However when number of parameters increase, consider to use builder pattern instead.
 */
public class StaticFactoryMethod {
	
	
	private static StaticFactoryMethod spareObj;
//	Immu make .equals( ) possible
	private static StaticFactoryMethod zeroObj;
	
	private int num;
	
	
	private StaticFactoryMethod(int num) {
		super();
		this.num = num;
	}


	/**
	 * Both static method are calling the same constructor with different paraemters
	 * If user have not access to doc and src code, it's difficult for them to notice stuff like:
	 * 
	 * Oh, I have to call constructor(int) with a even number to get evenObj and oddObj vise versa.
	 * By making use of static factory method, it make it so intuitive by calling StaticFactoryMethod.evenObj().  
	 * @return
	 */
	public static StaticFactoryMethod evenObj () {
		return new StaticFactoryMethod(2);
	}
	
	/**
	 * Save ur time for reading JavaDoc for must of the situations.
	 * @return
	 */
	public static StaticFactoryMethod oddObj () {
		return new StaticFactoryMethod(1);
	}

	/**
	 * Also cache are object reuse is possible especially on immutable object. 
	 * @return
	 */
	public static StaticFactoryMethod cacheObj(int num) {
		
		if (num == 0) {
			if (zeroObj == null) {
				zeroObj = new StaticFactoryMethod(0);
			}
			return zeroObj;
		}else {
			return new StaticFactoryMethod(num);
		}
	}


}
