package com.bookref.effectiveJava.commonMethod;

import java.util.Objects;

public class POJO {

	protected String key;
	protected String value;

	
	
	public POJO(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * If field is an array then iterate each item.
	 */
	@Override
	public int hashCode() {
//		Prime is chosen, cuz info would be lost when multiplication overflowed.
//		Multiple by 2 == shifting.
		final int prime = 31;
		int result = 1;
//		In practical 31*i == (i<<5)-i, but 31 is more readable and modern JVM support would optimize it on the fly.
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		
//		All above code can be replaced by following but slower.
		int h = Objects.hash(key, value);
		return result;
	}

	/**
	 * Example of equality provided. 
	 * May not be efficient but it's my own writing.
	 * 
	 * However following code would only work when String key and value 
	 * are having correct implementation of .equals( ) method. 
	 * 
	 * 
	 * Consideration when overriding equals method:
	 * 
	 *  - Reflexive
	 *  	Must be true compare to itself which is x.equals(x),
	 *  	Can be achieved by compare the memory address? 
	 *  	Which is the super method of object.
	 *  
	 *  - Symmetric
	 *  	 - x.equals(y) would return true, if both objects are 
	 *  	symmetric identical.  
	 *  
	 *  - Transitive
	 *  	- a.equals(b), b.equals(c) then a.equals(c)
	 *  
	 *  - Consistent
	 *  	- Result of .equals( ) method would stay constant.
	 *  
	 *  Reflexive & Symmetric are the base, Transitive and Consistent built upon it. 
	 */
	@Override
	public boolean equals(Object obj) {

		//Super method handle the reflexive by default.

		if (this == obj) {
			return true;
		}else if (obj == null) {
			return false;
		}else if (obj instanceof POJO) {
			
			/**
			 * When incoming object is confirmed to be the same type, 
			 * then can start to compare field by field. 
			 * 
			 * Key take-away:
			 *  - User == for all primitive type except double || float.
			 *  	- Make use of Float.compare(float, float), Double respectively, 
			 *  	but not Floast.equals as it cause auto-Boxing.
			 *  	- Ref: https://stackoverflow.com/questions/1088216/whats-wrong-with-using-to-compare-floats-in-java
			 *  
			 *  - Null pointer can be avoid via Objects.equals( ) call.
			 *  
			 *  - When object are complex then compare with canonical form,
			 *  just remember to update accordingly when field value changed. 
			 *  
			 *  - Status field is incomparable, stuff like stuff and counter.
			 *  
			 *  - Compare filed are more likely to be differ first, short circuit.
			 *  
			 *  - After yourself does all four criteria satisfied after override 
			 *  a equal call every time.  
			 *  
			 *  - Hashcode( ) need to be modified accordingly. Make sure all four criteria 
			 *  implemented on hashcode as well. If no idea then makeuse of CommonLang
			 *  
			 *  
			 */
			POJO o = (POJO) obj;
			//			Logically equal
			if (key.equals(o.key) &&
					value.equals(o.value)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	/**
	 * Space for a clone method, it's a failure in design.
	 * How a method clone suppose to be call when it's in protected state. 
	 * 
	 * The most weird thing is clone-able interface dun come with any method declaration.
	 * So in reality dev is expected a public clone() when obj equipped with cloneable (General contract).
	 * Even it's not specify on interface.  
	 * 
	 *  - No point for immutable to provide clone method, can just share the instance instead.
	 *  	 - May needed on thread local?
	 *  
	 *  - If clone method call( ) is note override at all, the base clone( ) would throw a
	 *  CloneNotSupportedException.
	 */
	public POJO clone () {
//		parent call of clone would simply return a replica of a object, for primitive is find
//		but when heaps objects, only the address would be copyed. So multiple object would linked to 
//		single obj underneath. 
		return new POJO(key, value);
	}


	/**
	 * Intention need to be marked crystal clear on toString call( ).
	 * As this class go vital, ppl may rely on the format of toString,
	 * so clarify that the format may change as the class itself evolve. 
	 * 
	 * Also make sure all information listed on toString( ) is accessible,
	 * so dev who make sure of the class no need to parse toStrin( ) to obtain
	 * value that they needed.
	 * 
	 *  - No sense to write toString( ) for static utility class || enum types. 
	 */
	@Override
	public String toString() {
		return "POJO [key=" + key + ", value=" + value + "]";
	}

	public static void main(String[] args) {
		
//		Bit shift is faster then multiple
		System.out.println( (10*32) == (10<<5) );
		
		POJO p = new POJO(null, null);
		System.out.println(p.clone().getClass() == p.getClass() );
		
	}

}
