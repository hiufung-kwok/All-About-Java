package com.util.regex;



/* Regex can be apply on either String / Class form. 
 * Following example is enough for most of the case, 
 * by taking those with you to work. Should be no problem at all.
 */
public class RegexExample {

	public static void main(String[] args) {
		
		//.* Match any thing.
		matchResult("hello", ".*");
		matchResult("", ".*");
		System.out.println();
		
		//Single Character by .
		matchResult("hello", ".");
		matchResult("h", ".");
		matchResult("", ".");
		System.out.println();
		
		//Begin with h then anything behind
		matchResult("hello", "^h.*");
		matchResult("world", "^h.*");	
		//Nothing != anything
		matchResult("", "^h.*");	
		System.out.println();
		
		
		//End of String
		//Start with any and end with e
		matchResult("banana", ".*e$");
		matchResult("apple", ".*e$");
		matchResult("orange", ".*e$");
		matchResult("melon", ".*e$");
		System.out.println();
		
		//Optional Char W?ilma mean either <Wilma || ilma>
		matchResult("ilma", "W?ilma");
		matchResult("Wilma", "W?ilma");
		matchResult("Hilma", "W?ilma");
		System.out.println();
		
		//Set, match any one on bracket (Only one)!
		matchResult("a", "[abc]");
		matchResult("b", "[abc]");
		matchResult("c", "[abc]");
		matchResult("ab", "[abc]");
		System.out.println();
		
		//Or a||b||c then followed by any char
		matchResult("ab", "[abc]*");
		matchResult("ab", "[abc]*");
		matchResult("abccca", "[abc]*");
		matchResult("abcd", "[abc]*");
		System.out.println();
		
		//Not in the set single char which is not a || b || c
		matchResult("a", "[^abc]");
		matchResult("b", "[^abc]");
		matchResult("c", "[^abc]");
		matchResult("d", "[^abc]");
		matchResult("dd", "[^abc]");
		System.out.println();
		
		//Range of char
		matchResult("a", "[a-d]");
		matchResult("b", "[a-d]");
		matchResult("cd", "[a-d]");
		matchResult("e", "[a-d]");
		System.out.println();
		
		// \w for word character [a-zA-Z0-9]
		// \W for opposite == ^\w
		matchResult("a", "\\w");
		matchResult("hello", "\\w");
		matchResult("6", "\\w");
		matchResult("7e", "\\w");
		matchResult("+", "\\w");
		System.out.println();
		
		//\d for digit and \D for non digit
		
		// \s for space 
		// + would keeping matching if invalid.
		matchResult("hello world", "\\w+\\s\\w+");
		matchResult("helloworld", "\\w+\\s\\w+");
		System.out.println();
		
		// Backslash for escape char
		matchResult("hello", "hel\\*o");
		matchResult("helo", "hel\\*o");
		matchResult("hel*o", "hel\\*o");
		System.out.println();
			
		
	}
	
	
	
	static void matchResult (String str, String pattern) {
		System.out.println("Matching \"" + str + "\" with (" + pattern + "): " + str.matches(pattern) );
	}
}
