package codePattern.OOP.inheritance_composition;


//Using inheritance for generate new object 

public class Insect {
    private int size;
    private String color;

    public Insect(int size, String color) {
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

    public void attack() {
        move();  
        System.out.println("Attack");
    }
}

