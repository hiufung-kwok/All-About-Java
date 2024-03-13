package designPattern.Factory.SimpleFactory;


/**
 * Ref: https://dzone.com/articles/factory-method-vs-simple-factory-1
 * 
 * 
 * Simple factory method( )
 * 
 *  - Have control on object creation 
 *  Following is how a simple factory would look like it take care of the Object creation by specificing 
 *  what type of Object is need. Then FoodStore would generate and return co-response Food object. There have
 *  several advantage brought straight to you for free.
 *  
 *  First behavour of the construction can all be centralised on one place, which would be huge aid especially 
 *  for library user. Since the operation is encapsulated, modification wouldn't lead to breaking change, as 
 *  long as maintaining the same signature for outside to consume. A quick example may help to understand the 
 *  concept.
 *  Let's say spec have changed, from this point onward Jpese CUISINE not returing Sushi but Sake instead.
 *  under factory method, code can be quickly change on Food(JPese) section to print out Sake. Which is not
 *  breaking change and as the signaure stay the same. End-user no need to alter code in order comply everyone happy.
 *  However fall into the case of normal Java Class. A JpeseFood is created to printout Sushi, but as the spec change.
 *  A new class need to be created for JpeseFoodSake in order to modify it's behavior.
 *  
 *  - Have its own behavior
 *  
 *  Also by one more level of encapsulation, extra code segment can be run exact before or after the constructor.
 *  Let's say you wanna to store the frequency of how often every classes is created throughout the whole life time.
 *  In this case, counter can be added and store under the FoodStore (Factory) classes. It general more fexibility 
 *  which a pure constructor model can't offer.   
 * 
 * 
 */
public class FoodStore {
	
	 enum CUISINE{CHINESE,JPESE,KOREAN};
	 
	    public static Food getFood(CUISINE type){
	    	
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




