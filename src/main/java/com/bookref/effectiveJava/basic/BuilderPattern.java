package com.bookref.effectiveJava.basic;

import java.util.Objects;

/**
 * Builder pattern help Obj with huge amount of parameters turn to a more readable way.
 * 
 * Why not?
 *  - May harm when it's on a performance-critical situation
 */
public class BuilderPattern {
	
	private final String nullWarn = "Title can't be null";
	
	private  String title = null;
	private  int workHr = 0;
	private double pay = 0.0;
	private  boolean medi = false;
	
	
	public BuilderPattern() {
	}
	
	
	public BuilderPattern(BuilderPattern val) {
		super();
		this.title = val.title;
		this.workHr = val.workHr;
		this.pay = val.pay;
		this.medi = val.medi;
	}
	
	
	public BuilderPattern title (String val) {
		title = val;
		return this;
	}
	public BuilderPattern  workHr (int val) {
		workHr = val;
		return this;
	}
	public BuilderPattern pay (double val) {
		pay = val;
		return this;
	}
	public BuilderPattern medi (boolean val) {
		medi = val;
		return this;
	}
	
	public BuilderPattern build ( ) {
		
//		Check can be performed here
		title = Objects.requireNonNull(this.title, nullWarn);
		return new BuilderPattern(this);
	}


	@Override
	public String toString() {
		return "BuilderPattern [title=" + title + ", workHr=" + workHr + ", pay=" + pay + ", medi=" + medi + "]";
	}
	
	public static void main(String[] args) {
//		It make so much sense by simply reading src.
		BuilderPattern b = new BuilderPattern()
								.title("AP").pay(15000.0)
								.medi(true).workHr(20)
								.build();
	}
	

	
}
