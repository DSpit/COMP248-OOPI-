package com.oop1.assignments.a5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implements search functions for the {@link CellPhone} class.
 * 
 * @author David Boivin (~AbSynth ~DSpit)
 */
public class CellPhoneSearch {
	
	public final static String AUTHOR = "David Boivin";
	public final static String ACCEPT = "yes";
	public final static long ID = 40004941;
	public final static int ARRAY_SIZE = 10;
	public final static int FIZZ = 2;
	public final static int BUZZ = 5;

	/**
	 * The main function of this program designed to test its class' search capabilities
	 * by creating and populating a pseudo-randomly generated array of {@link CellPhone}s.
	 * The program then asks the user for 3 parameters: brand, price, combination match.
	 * Using the inputs, the program then searches the array for matches using the 
	 * {@link #search(CellPhone[], String, double, boolean)} and displays the matching cellphone's 
	 * serial number.
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		CellPhone[] cellArray = new CellPhone[ARRAY_SIZE];
		CellPhone[] returnArray;
		String searchBrand;
		double searchPrice;
		
		CellPhoneSearch.populateCellArray(cellArray);
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
			for(int i = 0; i < returnArray.length; ++i){
				System.out.printf("%d) %d%n",i+1, returnArray[i].getSerial());
			}
		}
		
		kb.close();
	}
	
	/**
	 * Method providing search capabilities through a given array of {@link CellPhone}s by  price and
	 * brand. Capitalization is irrelevant for the brand, since it is turned into lower case. 
	 * 
	 * @param array The input array to search through
	 * @param brand The brand to search for.
	 * @param price The price to search for.
	 * @param matchCombo if <b>true</b> then the search will only return {@link CellPhone}s that 
	 * 						match both brand and price parameters, while <b>false</b> returns 
	 * 						{@link CellPhone}s that have either.
	 * 
	 * @return An array of {@link CellPhone}s that satisfy the search criteria, dictated by the parameters.
	 */
	public static CellPhone[] search(CellPhone[] array, String brand, double price, boolean matchCombo){
		CellPhone[] rArray = new CellPhone[array.length];
		int index = 0;	//index to keep track of next available location in rArray
		boolean foundBrand;
		boolean foundPrice;
		brand = brand.trim().toLowerCase();
		
		//search through the array
		for(int i = 0; i < array.length; ++i){
			//checks main conditions
			foundBrand = brand.equals(array[i].getBrand());
			foundPrice = price == array[i].getPrice();
//			System.out.printf("Brand: %s Price: %s%n", String.valueOf(foundBrand), String.valueOf(foundPrice));		//DEBUG
//			System.out.println((foundBrand && foundPrice) || (!matchCombo && (foundBrand || foundPrice)));

			
			//logic wizardry to remove the need for nested ifs compounding results according to comboMatch
			if((foundBrand && foundPrice) || (!matchCombo && (foundBrand || foundPrice))){
				rArray[index++] = array[i];		//if match then put it in return array
			}
		}

		//retrun proper length sized array
		return Arrays.copyOfRange(rArray, 0, index);
	}
	
	/**
	 * Private method designed to populate the testing array of this class.
	 * The Method accepts an array of {@link CellPhone} as input and fills it according
	 * to a fizzbuzz algorithm on the array's index, where each of the fizz, buzz, and fizzbuzz instances are
	 * used to copy 3 different "default" CellPhones. Any non-fizzy instances generate a random {@link CellPhone} from
	 * it's default values:
	 * <br>{@link CellPhone#PRICE_MIN} <= price <= {@link CellPhone#PRICE_MAX}
	 * <br>brands: {@link CellPhone#BRANDS}
	 * 
	 * <br><br>The 3 default {@link CellPhone} are:
	 * <br>1} <code>CellPhone("a", -1, (CellPhone.PRICE_MIN + CellPhone.PRICE_MAX) / 2.0)</code>
	 * <br>2} <code>CellPhone("b", -2, (CellPhone.PRICE_MAX)</code>
	 * <br>3} <code>CellPhone("c", -3, (CellPhone.PRICE_MIN)</code>
	 * 
	 * @param array
	 */
	private static void populateCellArray(CellPhone[] array){
		//arbitrary cell phones to be used to demonstrate copy constructor
		CellPhone 	fizzbuzz = new CellPhone("a", -1, (CellPhone.PRICE_MIN + 
															CellPhone.PRICE_MAX) / 2.0),
					fizz = new CellPhone("b", -2, CellPhone.PRICE_MAX),
					buzz = new CellPhone("c", -3, CellPhone.PRICE_MIN); 
		
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
				array[i] = new CellPhone(CellPhone.getRandomBrand(), 
										(long)i,
										CellPhone.getRandomPrice());
			}
		}
	}
	
	/**
	 * Convenience method for fizzbuzz condition, which is both
	 * {@link #fizz(int)} and the {@link #buzz(int)} must be <b>true</b>. 
	 * 
	 * @param index index to check condition agains
	 * @return <b>true</b> if the index is and instance of fizzbuzz.
	 */
	private static boolean fizzbuzz(int index){
		return CellPhoneSearch.fizz(index) && CellPhoneSearch.buzz(index);
	}
	
	/**
	 * Convenience method for fizz condition, which is that 
	 * the index parameter is a multiple of {@link #FIZZ}.
	 * 
	 * @param index The index to check the condition against.
	 * @return <b>true</b> if the index is an instance of fizz.
	 */
	private static boolean fizz(int index){
		return index % FIZZ == 0;
	}
	
	/**
	 * Convenience method for buzz condition, which is that 
	 * the index parameter is a multiple of {@link #BUZZ}.
	 * 
	 * @param index The index to check the condition against.
	 * @return <b>true</b> if the index is an instance of buzz.
	 */
	private static boolean buzz(int index){
		return index % BUZZ == 0;
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
	
	public final static String[] BRANDS = {"google", "apple", "samsung", "nokia"};
	public final static double PRICE_MIN = 200.0;
	public final static double PRICE_MAX = 1000.0;

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
	
	public static String getRandomBrand(){
		return BRANDS[(int)Math.random()*BRANDS.length];
	}
	
	public static double getRandomPrice(){
		return PRICE_MIN + Math.random()*(PRICE_MAX-PRICE_MIN);
	}
}
