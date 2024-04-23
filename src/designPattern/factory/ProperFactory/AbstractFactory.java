package designPattern.factory.ProperFactory;

import designPattern.factory.SimpleFactory.Food;

public abstract class AbstractFactory {

	enum CUISINE{CHINESE,JPESE,KOREAN};
	
	public final void orderDelivery(CUISINE type) {
		//Can call method which not define which is totally fine, as 
		//long as the implementation remain the same signature.
		getFood(type);
		getDrink();
		System.out.println("Food & Drink");
	}

	protected abstract int getDrink();
	protected abstract Food getFood(CUISINE type);

}
