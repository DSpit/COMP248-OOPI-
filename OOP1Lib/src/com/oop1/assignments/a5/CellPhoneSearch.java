package com.oop1.assignments.a5;

public class CellPhoneSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Designed to allow easy and efficient storage and retrieval of 
 * information about a particular cell phone. The data stored in this
 * class include the brand, serial number and price of the cell phone. 
 * <br><br><b>Note:</b> The values stored in this class are all mutable 
 * 							and have no assignment restrictions.
 * 
 * @author David Boivin (~AbSynth ~DSpit)
 */
class CellPhone {

	protected String mBrand;
	protected long mSerial;
	protected double mPrice;
	
	/**
	 * Constructor which assigns every field the appropriate parameter.
	 * 
	 * @param brand The cell phone's brand.
	 * @param serial The cell phone's serial number
	 * @param price The cell phone's price.
	 */
	public CellPhone(String brand, long serial, double price){
		this.setBrand(brand);
		this.setSerial(serial);
		this.setPrice(price);
	}
	
	/**
	 * Basic copy constructor.
	 * 
	 * @param c CellPhone object to copy all the values from 
	 * 			and assign them to this new object's fields.
	 */
	public CellPhone(CellPhone c){
		//uses normal constructor to set all fields
		this(c.getBrand(),
			c.getSerial(),
			c.getPrice());
	}
	
	/**
	 * @return The cell phone's brand.
	 */
	public String getBrand(){
		return mBrand;
	}
	
	/**
	 * @return The cell phone's serial number.
	 */
	public long getSerial(){
		return mSerial;
	}
	
	/**
	 * @return The cell phone's price.
	 */
	public double getPrice(){
		return mPrice;
	}
	
	/**
	 * Assigns the new brand of the phone's brand field.
	 * 
	 * @param brand New brand name for this phone.
	 */
	public void setBrand(String brand){
		mBrand = brand;
	}
	
	/**
	 * Assigns the new serial number to the phone's field.
	 * 
	 * @param serial The new serial number for this phone.
	 */
	public void setSerial(long serial){
		mSerial = serial;
	}
	
	/**
	 * Assigns the price of the phone if the price parameter is
	 * greater than or equal to 0..
	 * 
	 * @param price The new price of this phone.
	 * @return <b>true</b> if the new price is greater than or equal to 0
	 * 			and the phone's price has been reassigned and <b>false</b> if 
	 * 			phone's price hasn't been reassigned.
	 */
	public boolean setPrice(double price){
		//makes sure the price is legal
		if(price >= 0){
			mPrice = price;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Two {@link CellPhone} objects are equal if the have the same brand, serial number and price.
	 */
	@Override
	public boolean equals(Object obj){
		//checks if object is in fact a cell phone
		if(!(obj instanceof CellPhone)){
			return false;
		}
		
		//checks that all the fields are equals
		CellPhone c = (CellPhone) obj;
		if(c.getPrice() == this.getPrice() && 
			c.getSerial() == this.getSerial() &&
			c.getBrand().equals(this.getBrand())){
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Returns a string with three lines each representing one of the phone's fields.
	 * <br><br><b>Note:</b> Each line is has an indentation.
	 */
	@Override
	public String toString(){
		return String.format("%20s%s%n%20s%d%n%20s%.2f$%n", 
				"Brand: ", this.getBrand(),
				"Serial Number: ", this.getSerial(), 
				"Price: " ,this.getPrice());
	}
}
