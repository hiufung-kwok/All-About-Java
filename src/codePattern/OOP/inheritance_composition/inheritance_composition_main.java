package codePattern.OOP.inheritance_composition;




public class inheritance_composition_main {

	public static void main(String[] args)  {
		
		/*
		 * As Bee have unique attack moving method (Fly) so need to overide,
		 *  also this way don't provide the flexibility as it should have,
		 *  what happen if some insect really can't move?
		 *  
		 * So in this situation, interface may be a better choice instead.
		 */
		
		//Inherence way
		Insect bee = new Bee (10, "Red");
		bee.attack();
		
		//Interface
		//But the problem is can't store as Insect object 
		Bee_normal new_bee = new Bee_normal (10,"Yellow");
		new_bee.attack();
	}
	
	
}
