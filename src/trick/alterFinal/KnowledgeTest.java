package trick.alterFinal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

//Ref: https://dzone.com/articles/how-to-change-private-static-final-fields?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
/*
 * One of the trick that set modify variable in private field.
 * Which would come in handy when preparing test case.
 * 
 */
public class KnowledgeTest {

	/**
	 * In this main, Knowledge would first be init with default constructor, with ANSWER = 42.
	 * However setFinalStaticField is call which appear to make ANSWER accessible from outside world
	 * and also alter the value from 42 to 41. So by the end when askQuestion is call. It print 41
	 * instead of 42. 
	 * @param args
	 * @throws ReflectiveOperationException
	 */
	public static void main(String[] args) throws ReflectiveOperationException {
		  Knowledge knowledge = new Knowledge();
	        String answer = knowledge.askQuestion("question?");
	        System.out.println(answer);
	      
	        setFinalStaticField(Knowledge.class, "ANSWER", 41);
	        answer = knowledge.askQuestion("question?");
	        System.out.println(answer);
	}
	

    
    
    private static void setFinalStaticField(Class<?> clazz, String fieldName, Object value)
            throws ReflectiveOperationException {
    	
    	//Get the field
        Field field = clazz.getDeclaredField(fieldName);
        //Set to public 
        field.setAccessible(true);
        
        //Set value
        Field modifiers = Field.class.getDeclaredField("modifiers");
        //Private member to public accessible 
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, value);
    }
}