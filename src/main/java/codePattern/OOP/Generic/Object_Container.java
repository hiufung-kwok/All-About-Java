package codePattern.OOP.Generic;

/*
 * In here we define all member type into Object class,
 * as it it the root class of any Java object. 
 * 
 * Compile would allow any class pass in as they inherit from class
 * <Object>. 
 * 
 * Although it let the flexibility go up, however the operation within
 * the class is limited as only method <Object> class method is allow to 
 * call. But not other class specific operation, cuz compiler can't forecast 
 * what object would be pass in. Hence something like <Integer< i.toBinaryString(i)
 * is prohibited.
 */



public class Object_Container {
	
	private Object key;
	private Object value;
	
	public Object_Container (Object k , Object v) {
		this.key = k;
		this.value = v;
		
	}
	
	
	public void print () {
		System.out.print(key);
		System.out.print(value);
		System.out.println();
	}
	
	
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
