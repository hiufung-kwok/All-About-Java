package com.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * Is a must for a business oriented programmer. 
 * @author andykwok
 *
 */
public class simpleUage {
	
	
	public static void normalOperation () {
		
		BigDecimal base = new BigDecimal (1);
		BigDecimal other = new BigDecimal (3);
		System.out.println("1 - 3 = " + base.add(other).toString());
		System.out.println("1 + 3 = " + base.subtract(other).toString());
		System.out.println("1 * 3 = " + base.multiply(other).toString());
		
		//Need to handle exception when doing divide
		try {
		System.out.println("1 / 3 = " + base.divide(other).toString());
		}catch (ArithmeticException  ae) {
			ae.printStackTrace();
		}
		
	}
	
	/**
	 * Demonstrate how decimalFormat can be used to properly format number in local way (Locale).
	 * 
	 */
	public static void DecimalFormatting() {
		BigDecimal price = new BigDecimal(100.123456789);
		//Number would loss precision which can't be rely to produce accurate result with large numbers
		//Limited to 2 digit places by default. 
		NumberFormat uk = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println(uk.format(price));
		System.out.println(uk.format(price.doubleValue()));
		
		//So .setScale( ) is needed for accurate result. 
		price = price.setScale(4, BigDecimal.ROUND_DOWN);
		System.out.println(price.toString());
	}
	
	
	/**
	 * Its number (int || double || float) but not bigDecimal!
	 * 
	 *  - # mean digit
	 *  - , mean place holder 
	 *  
	 *  Example: 
	 *   - 12345.999 ( ###.## ) -> 12345.999
	 *   As src 3 digits in tail but formatter only two, so round up.
	 *   
	 *   - 12.5 (000.00) -> 012.50
	 *   All unused digits would have 0 for default. 
	 *   
	 *   - 12.5 (###.##) ->12.5
	 *   As # wouldn't appear if digit is not filled. 
	 *   
	 *   DecialFormaSymbols having following properties:
	 *   - DecimalSeparator
	 *   - GroupingSeparator
	 *   - Group size
	 *   
	 *  Detail can be found on: https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
	 *   
	 *   
	 *   
	 */
	public static void numberFormatting() {
		
		numberFormatTester(123.78999,"###.##", "As only ## specified after deicmal place - it will round up");
		numberFormatTester(123.78999,"$###,###.00000000", "Dollar sign specified");
		numberFormatTester(123456.78999,"$###,###.#", "Saperator");
		numberFormatTester(1234514.9,"$###,###.#", "Dollar sign specified");
		numberFormatTester(0.35,"###.##%", "Percentage * 100");
	}
	
	//-----------------------------------Util----------------------------------
	private static void numberFormatTester (double data, String format, String remark) {
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		DecimalFormat formatter = (DecimalFormat)nf;
		formatter.applyPattern(format);
		String result = formatter.format(data);
		System.out.println(StringUtils.leftPad(String.valueOf(data), 20) + " -> " + 
						   StringUtils.rightPad(format, 20) + " = " + 
						   StringUtils.rightPad(result, 15) + "(" + remark + ")");
			
	}
	
	public static void main(String[] args) {

		normalOperation();
		DecimalFormatting();
		numberFormatting();
		
		
	}
}
