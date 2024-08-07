package com.lang.compareable;



public class Lappy implements Comparable<Lappy>  {
	
	private String Brand;
	private int P_power;
	private double Weight;
	
	public Lappy (String brand, int processing_power , double weight) {
		
		this.Brand = brand;
		this.P_power = processing_power;
		this.Weight = weight;
	}
	
	

	public String getBrand() {
		return Brand;
	}


	public int getP_power() {
		return P_power;
	}



	public double getWeight() {
		return Weight;
	}




	@Override
	public int compareTo(Lappy o) {
		
		
		//Compare the computing power first (Always)
		if (this.P_power > o.getP_power() ) {
			return 1;
		}else if (this.P_power < o.getP_power() ) {
			return -1;
		}else if (this.P_power == o.getP_power() ) {
			
			//Compare weight then 
			if (this.Weight > o.getWeight() ) {
				return 1;
			}else if (this.Weight < o.getWeight() ) {
				return -1;
			}else if (this.Weight == o.getWeight() ) {
				return 0;		
			}
		}
		
		return 0;
	}



	

}
