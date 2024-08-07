package codePattern.OOP.inheritance_composition;

//Unlike Insect, move and attack method are not included in class.

public class Insect_normal {


	private int size;
	private String color;

	public Insect_normal(int size, String color) {
		this.size = size;
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void move() {
		System.out.println("Move");
	}

}

