package codePattern.OOP.Generic;

//K, V used for representing key value pair
public class Generic_Container <K, V> {
	
	private K key;
	private V value;
	
	/*Take any type of object instead of Object obj 
	 * even it did the same thing.
	 */
	public Generic_Container (K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	
	public void print () {
		System.out.print(key);
		System.out.print(value);
		System.out.println();
	}


	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}
	
	
	
	
	

}
