package codePattern.OOP.inheritance_composition;

//Only append attack method if needed to.

public class Bee_normal extends Insect_normal implements Attack {

	public Bee_normal(int size, String color) {
		super(size, color);
	}

	@Override
	public void attack() {
		super.move();
		System.out.println("Attack");
		
	}

}
