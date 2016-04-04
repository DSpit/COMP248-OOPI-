package com.oop1.assignments.a5;

import java.util.Arrays;
import java.util.Scanner;

public class CellPhoneSearch {
	
	public final static String AUTHOR = "David Boivin";
	public final static String ACCEPT = "yes";
	public final static long ID = 40004941;
	public final static int ARRAY_SIZE = 10;
	public final static int FIZZ = 2;
	public final static int BUZZ = 5;
	public final static double PRICE_MIN = 200.0;
	public final static double PRICE_MAX = 1000.0;
	
	public final static String[] BRANDS = {"google", "apple", "samsung", "nokia"};
	

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		CellPhone[] cellArray = CellPhoneSearch.populateCellArray(ARRAY_SIZE);
		CellPhone[] returnArray;
		String searchBrand;
		double searchPrice;
		
		System.out.println(Arrays.toString(cellArray));
		
		//introduce the program
		System.out.printf("Welcome to %s's Cell Phone Search Program%n%n", AUTHOR);

		//prompt user for search parameters
		System.out.print("Brand to search: ");
		searchBrand = kb.nextLine();
		System.out.print("Price to Search: ");
		searchPrice = kb.nextDouble();
		kb.nextLine();	//clear buffer
		System.out.printf("Choose match combinations by entering [%s]: ", ACCEPT);
		
		//search array
		returnArray = CellPhoneSearch.search(cellArray, searchBrand, searchPrice, 
				kb.nextLine().trim().toLowerCase().equals(ACCEPT));
		
		//display results
		System.out.println("Matching results: ");
		if(returnArray.length == 0){
			System.out.println("No matches were found.");
		}else{
			int index = 0;
			while(returnArray[index] != null || index < returnArray.length){
				System.out.printf("%d) %d%n",index+1, returnArray[index].getSerial());
				++index;
			}
		}
		
		kb.close();
	}
	
	public static CellPhone[] search(CellPhone[] array, String brand, double price, boolean matchCombo){
		CellPhone[] rArray = new CellPhone[array.length];
		int index = 0;
		boolean foundBrand;
		boolean foundPrice;
		brand = brand.trim().toLowerCase();
		
		for(int i = 0; i < array.length; ++i){
			foundBrand = brand.equals(array[i].getBrand());
			foundPrice = price == array[i].getPrice();
			System.out.printf("Brand: %s Price: %s%n", String.valueOf(foundBrand), String.valueOf(foundPrice));
			System.out.println((foundBrand && foundPrice) || !(matchCombo && !(foundBrand || foundPrice)));
			
			//logic wizardry to remove the need for nested ifs
			if((foundBrand && foundPrice) || (!(matchCombo) || (foundBrand || foundPrice))){		//FIXME
				rArray[index++] = array[i];
			}
		}
		
		return rArray;
	}
	
	private static CellPhone[] populateCellArray(int size){
		CellPhone[] array = new CellPhone[size];
		//arbitrary cell phones to be used to demonstrate copy constructor
		CellPhone 	fizzbuzz = new CellPhone("a", -1, (PRICE_MIN + PRICE_MAX) / 2.0),
					fizz = new CellPhone("b", -2, PRICE_MAX),
					buzz = new CellPhone("c", -3, PRICE_MIN); 
		
		//populate array
		for(int i = 0; i < array.length; ++i){
			
			//use simple fizzbuzz game to keep the population interesting
			if(CellPhoneSearch.fizzbuzz(i)){
				array[i] = new CellPhone(fizzbuzz);
				
			}else if(CellPhoneSearch.buzz(i)){
				array[i] = new CellPhone(buzz);
				
			}else if(CellPhoneSearch.fizz(i)){
				array[i] = new CellPhone(fizz);
				
			}else{									//case of normal number: generate random cell phone 
				array[i] = new CellPhone(CellPhoneSearch.getRandomBrand(), 
										(long)i,
										CellPhoneSearch.getRandomPrice());
			}
		}
		
		return array; 
	}
	
	private static boolean fizzbuzz(int index){
		return CellPhoneSearch.fizz(index) && CellPhoneSearch.buzz(index);
	}
	
	private static boolean fizz(int index){
		return index % FIZZ == 0;
	}
	
	private static boolean buzz(int index){
		return index % BUZZ == 0;
	}
	
	private static double getRandomPrice(){
		return PRICE_MIN + Math.random()*(PRICE_MAX-PRICE_MIN);
	}
	
	private static String getRandomBrand(){
		return BRANDS[(int)Math.random()*BRANDS.length];
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
		mBrand = brand.toLowerCase();
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
			mPrice = ((int)price*100)/100.0;
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
		return String.format("%s%s%n%s%d%n%s%.2f$%n", 
				"Brand: ", this.getBrand(),
				"Serial Number: ", this.getSerial(), 
				"Price: " ,this.getPrice());
	}
}
