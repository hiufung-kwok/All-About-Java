package trick.alterFinal;
/**
 * Ref: https://dzone.com/articles/how-to-change-private-static-final-fields?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 * 
 * In this example we have a class call knowledge which contain private final field call answer.
 * Which init with 42. And askQuestion served as a getter to print out ANSWER value. Which "suppose" 
 * to stay constant. 
 * 
 */
public class Knowledge {
	
	/**
	 * Not work primitive type so (Integer -> int)
	 */
    private static final Integer ANSWER = 42;
    
    public String askQuestion(String question) {
        return "The answer to '" + question + "' is: " + ANSWER;
    }
}