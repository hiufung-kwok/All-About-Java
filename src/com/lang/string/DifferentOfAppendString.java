package com.lang.string;


/* The following piece of code show three possible ways of append String instance 
 * one into other. Which String +=, String Builder, String Buffer.
 * 
 * Conclusion:
 *  - As String class immutable, new instance created every time Str += Str1.
 *  - StringBuffer not creating object, but sync. Its the saftest way but not optimal.
 *  - StringBuilder is StringBuffer without sync. Which would boost more performance,
 *  Not promise in term of consistency.   
 * 
 */
public class DifferentOfAppendString {

	public static void main(String[] args) {
		
		
		String content = new String ("");
		
		//naive way
		for(int i=0 ; i<100 ; i++) {
			content += Integer.toString(i);
		}
		
		content = new String ("");
		StringBuffer strBuff = new StringBuffer(content);
		
		for (int i=0 ; i<100 ; i++) {
			strBuff.append(Integer.toString(i));
		}
		content = strBuff.toString();
		
		
		content = new String ("");
		StringBuilder strBuild = new StringBuilder(content);
		
		for (int i=0 ; i<100 ; i++) {
			strBuild.append(Integer.toString(i));
		}
		content = strBuild.toString();
		
		
		

	}

}
