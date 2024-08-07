package com.util.regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;



/**
 * Following is the main use case of Pattern, divided to two ways and the Pattern class play a large amont those.
 * Which primarily store regex syntax, which can then be used on those classes. Noted that Pattern is generated via
 * Pattern.comple("xxx"); method and you may notice or not but Pattern Syntax Exception would be thrown if given String
 * regex pattern is not valid. Just be caution especially when incoming patter not staying static. Which is either input
 * via user or set on config.
 * 
 *   
 * Personally not encouraging to use String.split( ), cuz it gonna throw PatternSyntaxException any way but in this way, 
 * dev like me dun notice it at all. Not expecting a excpetion would be thrown, so catch block is absent. 
 * 
 * Last but not least, Pattern.asPredicate() would be great when come into world of Java8. Make it integrated with zero effort.
 * Example can be found on here[URL]
 * 
 */
public class Application {

	public static void main(String[] args) {
		
		userSpliting();
		PatternStreamMatch();
	}

	/**
	 * It totally fine for using String.split when dealign with one off case,<br>
	 * but if need in multiple place then its wise packed it as a pattern class<br>
	 * ref: http://www.javaworld.com/article/3195301/learn-java/java-101-regular-expressions-in-java-part-2.html#tk.rss_all
	 */
	private static void userSpliting () {
		
		
		//Reusable
		Pattern p = Pattern.compile(",\\s");
		String[] fields = p.split("John Doe, 47, Hillsboro Road, 32000");
		for (int i = 0; i < fields.length; i++)
		   System.out.println(fields[i]);
		
		//One off (Disposable)
		String src = "John Doe, 47, Hillsboro Road, 32000";
		String[] fields_oneOff = src.split(",\\s");
		
		for (String str : fields_oneOff) {
			System.out.println(str);
		}
	}
	
	
	/**
	 * How u do in more simply way! (Stream)
	 */
	private static void PatternStreamMatch () {
		List<String> progLangs = Arrays.asList("apl", "basic", "c", "c++", "c#", "cobol",
				"java", "javascript", "perl", "python", 
				"scala");
		//Start with c
		Pattern p = Pattern.compile("^c");
		progLangs.stream().filter(p.asPredicate()).forEach(System.out::println);

	}
}
