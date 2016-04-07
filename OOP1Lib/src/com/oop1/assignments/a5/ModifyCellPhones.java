// -----------------------------------------------------
// Assignment 5
// Question: 1 & 2
// Written by: David Boivin (40004941)
// -----------------------------------------------------

package com.oop1.assignments.a5;

import java.util.Random;
import java.util.Scanner;

public class ModifyCellPhones {
	
	public static final int PRICE_MIN = 100;
	public static final int PRICE_MAX = 299;
	public static final double DEFAULT_ARBITRARY_PRICE= 124.00;
	
	/**
	 * Program designed to create a 2D array of {@link CellPhone}s which are then
	 * arbitrarily searched through and updated using arbitrarily hard-coded fetch and replace
	 * values which logging the location of each change and the total number of changes, which it displays.
	 * This program the displays the changed array.
	 */
	public static void main(String[] args) {
		CellPhone[][] array = new CellPhone[10][10];
		Scanner kb = new Scanner(System.in);
		int modifyCount = 0;
		
		//populate and display orginal array
		ModifyCellPhones.populate2DArray(array);
		System.out.println("Original phone prices: ");
		ModifyCellPhones.displayPrices(array);
		
		//modify selected array items
		modifyCount += ModifyCellPhones.modifyPhonePrices(array, DEFAULT_ARBITRARY_PRICE, 299.00);
		modifyCount += ModifyCellPhones.modifyPhonePrices(array, 157.00, 100.00);
		
		//display end result of modifications
		System.out.printf("Total changes: %d%n", modifyCount);
		System.out.println("Modified phone prices:");
		ModifyCellPhones.displayPrices(array);
		
		kb.close();
	}
	
	/**
	 * Algorithm used to modify the prices of the {@link CellPhone}'s in the given parameter of
	 * 2D arrays, by finding the {@link CellPhone}s matching the oldPrice parameter and replacing
	 * that {@link CellPhone}'s price with the newPrice.
	 * 
	 * @param array Array of {@link CellPhone}s to iterate through.
	 * @param oldPrice The price to look for while searching.
	 * @param newPrice The price to replace any search matches.
	 * @return The total number of matches found.
	 */
	public static int modifyPhonePrices(CellPhone[][] array, double oldPrice, double newPrice){
		int count = 0;
		
		//iterate through the array
		for(int i = 0; i < array.length; ++i){
			for(int j = 0; j < array[0].length; ++j){
				
				//if the old price matches the elements price, then change it with the new price.
				if(array[i][j].getPrice() == oldPrice){
					
					array[i][j].setPrice(newPrice);
					count++;		//update count
					System.out.printf("Log change at index [%d][%d]%n",i ,j);	//log change
				}
			}
		}
		
		//return total number of changes
		return count;
	}
	
	/**
	 * Convenience method designed to populate a given array with randomly priced {@link CellPhone}s, all
	 * with arbitrary brands (<code>"a"</code>) and arbitrary serial number (<code>-1</code>).
	 * This method will have a 0.1 probability of creating a {@link CellPhone} from a default object
	 * with parameters <code>CellPhone(brand, serial, DEFAULT_ARBITRARY_PRICE)</code> where 
	 * {@link DEFAULT_ARBITRARY_PRICE}.
	 * 
	 * <br><br><b>NOTE: </b> that the randomly created prices are within the range [{@link #PRICE_MIN}, {@link #PRICE_MAX}]
	 * 
	 * @param array Array to populate
	 */
	private static void populate2DArray(CellPhone[][] array){
		double prob = 0.1;		//a little above 0.06 just to make sure there's more chances that there will in fact be at least 6.
		long serial = -1;		//arbitrary
		String brand = "a";		//arbitrary
		Random r = new Random();
		CellPhone defCell = new CellPhone(brand, serial, DEFAULT_ARBITRARY_PRICE);
		
		//loop through array
		for(int i = 0; i < array.length; ++i){
			for(int j = 0; j < array[0].length; ++j){
				
				//create CellPhone object using copy constructor
				if(Math.random() < prob){
					array[i][j] = new CellPhone(defCell);
					continue;
				}
				
				//create new randomly priced object
				array[i][j] = new CellPhone(brand, serial, PRICE_MIN + r.nextInt(PRICE_MAX-PRICE_MIN));
			} 
		}
	}
	
	/**
	 * Displays the price of the elements held within the given array in a simply grid 
	 * display with spacing between each element..
	 * 
	 * @param array Array to display
	 */
	private static void displayPrices(CellPhone[][] array){
		//iterate through the array
		for(int i = 0; i < array.length; ++i){
			for(int j = 0; j < array[0].length; ++j){
				
				//display formatted price
				System.out.printf("%-10.2f", array[i][j].getPrice());
			}
			
			//go to next line after column has been iterated through
			System.out.println();
		}
	}
}
