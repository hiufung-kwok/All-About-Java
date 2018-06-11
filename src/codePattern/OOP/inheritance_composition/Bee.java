package codePattern.OOP.inheritance_composition;



//As Bee have it unique attack method, so need to overwrite.  

public class Bee extends Insect {
	
    public Bee(int size, String color) {
        super(size, color);
    }

    public void move() {
        System.out.println("Fly");
    }

    public void attack() {
       // move();
        super.attack();
    }
}