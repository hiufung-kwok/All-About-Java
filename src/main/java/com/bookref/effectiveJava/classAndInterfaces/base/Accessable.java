package com.bookref.effectiveJava.classAndInterfaces.base;

public class Accessable implements AutoCloseable{

//	It self
	private int a;
//	Default accessor only allow same package access
	int b;
//	Open to sub-classes and same package
	protected int c;
	public int d;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
