// -----------------------------------------------------
// Assignment 2
// Written by: David Boivin (40004941) ~AbSynth/DSpit
// -----------------------------------------------------

package com.oop1.assignments.a2;

import java.util.Scanner;

/**
 * This class represents a simple version of a cash register. The user must
 * enter the necessary information such as the GST rate and the QST rate as
 * well as all products they wish to buy. This class provides methods to 
 * compound all of this information and to calculate the total cost of all
 * entered products.
 * 
 * @author David Boivin ~AbSynth
 */
public class CashRegister{

	public final static String AUTHOR = "David Boivin";
	public final static int ID = 40004941;
	
	public final static int MIN_PRODUCT = 1;
	public final static int MAX_PRODUCT = 10;
	public final static double MIN_PRODUCT_COST = 1.0;
	public final static double MAX_PRODUCT_COST = 1000.0;
	public final static double MIN_TAX_PERCENTAGE = 0.0;
	public final static double MAX_GST_PERCENTAGE = 14.0;
	public final static double MAX_QST_PERCENTAGE = 17.0;

	private double mSubtotal;
	private double mGrate;
	private double mQrate;
	
	/**
	 * Default constructor which sets all fields (subtotal, gst rate and 
	 * qst rate)to zero. 
	 */
	public CashRegister(){
		mSubtotal = 0;
		mGrate = 0;
		mQrate = 0;
	}
	
	/**
	 * Allows for user to add product price to the subtotal of the cash.
	 * This method will not add the product if it is outside of the range
	 * of accepted product price given by <br> {@link #MIN_PRODUCT_COST} and
	 * {@link #MAX_PRODUCT_COST}.
	 * 
	 * @param price The price of the product
	 * @return <b>true</b> if the price is within range and adds the product to
	 * 			the subtotal and <b>false</b> if the product does not get added.
	 */
	public boolean addProduct(double price){
		if(price >= MIN_PRODUCT_COST && price <= MAX_PRODUCT_COST){
			mSubtotal += price;	//adds price to subtotal
			return true;
		}
		return false;
	}
	
	/**
	 * Method which allows the user to set the gst rate for future calculations.
	 * This method accepts a decimal value as input but as a percentage for example 12.345% which
	 * it will then convert into decimal form by dividing by 100. The GST rate has a 
	 * minimum of {@link #MIN_GST_PERCENTAGE} and is capped at {@link #MAX_GST_PERCENTAGE}.
	 * 
	 * @param gRate The GST rate in percentage form.
	 * @return <b>true</b> if the gst rate is within the accepted range and is set and <b>false</b>
	 * 			if the given gst rate is not set.
	 */
	public boolean setGSTrate(double gRate){
		//check conditions 
		if(gRate >= MIN_TAX_PERCENTAGE && gRate <= MAX_GST_PERCENTAGE){
			mGrate = gRate/100;	//divides number to store it as a decimal value rather than a percentage
			return true;
		}
		return false;
	}
	
	/**
	 * Method which allows the user to set the QST rate for future caluclations.
	 * This method accepts a decimal value as input but as a pergcentage for example 12.345%
	 * which it will then convert into decimal for by deviting by 100. The QST range is {@link #MIN_QST_PERCENTAGE} and
	 * {@link #MAX_QST_PERCENTAGE}
	 * 
	 * @param qRate The QST rate in percentage form.
	 * @return <b>true</b> if the qst rate is within the accepted range and is set and <b>false</b> 
	 * 			if the given qst rate is not set.
	 */
	public boolean setQSTrate(double qRate){
		//checks conditions
		if(qRate >= MIN_TAX_PERCENTAGE && qRate <= MAX_QST_PERCENTAGE){
			mQrate = qRate/100;	//divides number to store it as a decimal value rather than a percentage
			return true;
		}
		return false;
	}
	
	/**
	 * Method which displays a nice formated receipt of  the subtotal, gst and qst as well as the
	 * final total of the transaction. This method will also clear the subtotal for the next transaction.
	 */
	public void printReceipt(){
		//pre-calculates all necessary values
		String outputFormat = "%-15s$ %,10.2f%n";	//base format of the receipt
		double gst = this.getGST();
		double qst = this.getQST();
		
		//prints out the receipt
		System.out.printf(outputFormat, "SubTotal:", mSubtotal);
		System.out.printf(outputFormat, "GST:", gst);
		System.out.printf(outputFormat, "QST:", qst); 
		System.out.printf(outputFormat, "Total:", this.getTotal());
		
		//clear the subtotal
		this.clearSubtotal();
	}
	
	/**
	 * Convenience method which clears the subtotal (sets it to zero)
	 */
	public void clearSubtotal(){
		mSubtotal = 0;
	}
	
	/**
	 * Calculates the GST with the subtotal and gst rate using the formula:
	 * <br> GST = Subtotal * G-Rate
	 * 
	 * @return the GST of the current subtotal.
	 */
	private double getGST(){
		return mGrate * mSubtotal;
	}
	
	/**
	 * Method used to calculate the QST using the formula
	 * <br>QST = (mSubtotal + GST) * Q-Rate
	 * 
	 * @return The QST which should be added in the total.
	 */
	private double getQST(){
		return mQrate * (mSubtotal + this.getGST());
	}
	
	/**
	 * Method used to calculate the total of the current subtotal, using 
	 * the formula:
	 * <br>Total = Subtotal + GST + QST
	 * 
	 * @return The total of the current subtotal.
	 */
	private double getTotal(){
		return mSubtotal + this.getGST() + this.getQST();
	}
	
	/**
	 * Basic implementation of CashRegister class. This implementation keeps track 
	 * of how many errors the user made as well as allowing the user to input their
	 * own values (within ranges given as constants of this class).
	 */
	public static void main(String[] args){
		CashRegister cash = new CashRegister();
		int itemsBought = 0;
		int fuckupCount = 0;
		Scanner soScan = new Scanner(System.in);
		
		//introduction to the program.
		System.out.printf("Welcome to Assignment 2\n\tWritten by" + AUTHOR + 
							"(%8d)%n%n \t Openning the AbSynth Cash Register...%n", ID);
		
		//query the user as to how many products they want to buy
		do{
			try{
				fuckupCount++;
				System.out.printf("Please enter the number [%d, %d] of items "
						+ "purchased by the user: ", CashRegister.MIN_PRODUCT, CashRegister.MAX_PRODUCT);
				itemsBought = Integer.parseInt(soScan.nextLine());
			}catch(NumberFormatException e){
				continue;
			}
			
		}while(itemsBought > CashRegister.MAX_PRODUCT || itemsBought < CashRegister.MIN_PRODUCT);
		fuckupCount--;	//tod ya (total number of tries - success(1) == fuckups)
		
		//run loop to ask for price of all products
		System.out.printf("All products are priced between %.2f$ and %,.2f$ inclusively.%n" ,
				CashRegister.MIN_PRODUCT_COST, CashRegister.MAX_PRODUCT_COST);
		
		for(int i = 1; i <= itemsBought; i++ ){
			double price = 0.0;
			do{
				try{
					fuckupCount++;
					System.out.printf("\tPrice of product %d: ", i);
					price = Double.parseDouble(soScan.nextLine());
				}catch(NumberFormatException e){
					continue;
				}
				
			}while(!cash.addProduct(price));
			fuckupCount--;
		}
		System.out.printf("%n");
		
		//query user for qst and gst
		double gst = -1, qst = -1;	//initial values are out of range (simple precaution and easy way of finding errors)
		do{
			try{
				fuckupCount++;
				System.out.printf("Please enter a GST rate in %% form [%.1f%%, %.1f%%]: ",
						CashRegister.MIN_TAX_PERCENTAGE, CashRegister.MAX_GST_PERCENTAGE);
				gst = Double.parseDouble(soScan.nextLine());
			}catch(NumberFormatException e){
				continue;
			}
			
		}while(!cash.setGSTrate(gst));
		fuckupCount--;
		
		do{
			try{
				fuckupCount++;
				System.out.printf("Please enter a QST rate in %% form [%.1f%%, %.1f%%]: ",
						CashRegister.MIN_TAX_PERCENTAGE , CashRegister.MAX_QST_PERCENTAGE);
				qst = soScan.nextDouble();
			}catch(NumberFormatException e){
				continue;
			}
			
		}while(!cash.setQSTrate(qst));
		fuckupCount--;
		System.out.printf("%n");
		
		//show fuckup count if needed
		if(fuckupCount != 0){
			System.out.printf("You have entered %d invalid inputs.%n", fuckupCount);
		}
		
		//print receipt 
		cash.printReceipt();
		
		//conclusion to the program
		soScan.close();
		System.out.printf("Thank you for using the AbSynth Cash Register, good bye.");
	}
}
