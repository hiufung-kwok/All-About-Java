package Java8.Lambda.data;

import org.apache.commons.lang3.StringUtils;

public class Coffee {

	private double price;
	private String name;
	
	public Coffee(double price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		str.append(StringUtils.rightPad(name, 15));
		str.append(StringUtils.rightPad(String.valueOf(price), 10));
		return str.toString();
	}

	public double getPrice() {
		return price;
	}
	
	
	
	
	
	
	
}
