package designPattern.ProperFactory;

import designPattern.SimpleFactory.Food;



/**
 * This time, the factory itself abstracted away. Which have partial of its behavour 
 * cane be defined over AbstractFactory classes and those method can actual use 
 * the method which is not implemented, method like getFood and getDrink. On abstract 
 * factory, a concrete method - orderDelivery( ) called both getFood & Drink. 
 * 
 * In this way, factory itself gain more control not just object creation but more to
 * management of the product.
 */
public class ActualFactory extends AbstractFactory {

		@Override
		protected int getDrink() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		protected Food getFood(CUISINE type) {

			if(type.equals(CUISINE.JPESE)){
				return new Food(){
					@Override
					public void cookFood() {
						System.out.println("Sushi");
					}
				};
			}
			return null;			
		}
}