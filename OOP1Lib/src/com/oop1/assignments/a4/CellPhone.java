package com.oop1.assignments.a4;

/**
 * A mock cell phone class which contains data about a given cell phone.
 * This class can hold the cerial number, the brand and the price of the cell phone. 
 * 
 * @author David Boivin
 */
public class CellPhone {

	private String mBrand;
	private long mSerialNum;
	private double mPrice;
	
	/**
	 * Constructor which assigns each parameter to their respective fields of the newly
	 * initialized cell phone.
	 * 
	 * @param brand	The cell phone's brand.
	 * @param serial The cell phone's serial number.
	 * @param price The cell phones's price.
	 */
	public CellPhone(String brand, long serial, double price){
		mBrand = brand;
		mSerialNum = serial;
		mPrice = price;
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param cell The cell phone to copy all the information from.
	 */
	public CellPhone(CellPhone cell){
		mBrand = cell.getBrand();
		mSerialNum = cell.getSerialNumber();
		mPrice = cell.getPrice();
	}
	
	/**
	 * @return Cell phone's brand.
	 */
	public String getBrand(){
		return mBrand;
	}
	
	/**
	 * @return Cell phone's serial number.
	 */
	public long getSerialNumber(){
		return mSerialNum;
	}
	
	/**
	 * @return Cell phone's price.
	 */
	public double getPrice(){
		return mPrice;
	}
	
	/**
	 * @param brand The new modified brand to set to this object.
	 */
	public void setBrand(String brand){
		mBrand = brand;
	}
	
	/**
	 * @param serial The new modified serial number to set to this object.
 	 */
	public void setSerialNumber(long serial){
		mSerialNum = serial;
	}
	
	/**
	 * @param price The new modified price to set to this object.
	 */
	public void setPrice(double price){
		mPrice = price;
	}
	
	/**
	 * Overrides {@link Object#toString()} to output a string containing all the information 
	 * about this cell phone.
	 */
	@Override
	public String toString(){
		return String.format("Brand: %s%nSerial Number: %9d%nPrice: %.2f$%n", mBrand, mSerialNum, mPrice);
	}
	
	/**
	 * Overrides {@link Object#equals()} to check if the given object is in fact a {@link CellPhone}
	 * and that it has the same brand and price as the object this method is called from.
	 */
	@Override
	public boolean equals(Object obj){
		//check if the given object is in fact a CellPhone
		if(!(obj instanceof CellPhone)){
			return false;
		}
		
		//checks the brand and price of the parameter object
		CellPhone cell = (CellPhone)obj;
		if(mBrand.equals(cell.getBrand()) && 
				mPrice == cell.getPrice()){
			return true;
		}
		
		return false;
	}
}
