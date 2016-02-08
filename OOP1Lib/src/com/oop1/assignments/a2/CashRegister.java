// -----------------------------------------------------
// Assignment 2
// Written by: David Boivin (40004941) ~AbSynth/DSpit
// -----------------------------------------------------

package com.oop1.assignments.a2;

import java.util.LinkedList;
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
	public final static int MIN_PRODUCT_COST = 1;
	public final static int MAX_PRODUCT_COST = 1000;
	public final static int MIN_GST_PERCENTAGE = 0;
	public final static int MAX_GST_PERCENTAGE = 14;
	public final static int MIN_QST_PERCENTAGE = 0;
	public final static int MAX_QST_PERCENTAGE = 17;
	
	private final double fGRate;
	private final double fQRate;

	private double mSubtotal = 0;
	private int fuckupCount = 0;
	
	private Scanner kb = new Scanner(System.in);
	
	public CashRegister(){
		//query the user as to how many products they want to buy
		
		
		//run loop to ask for price of all products
		
		//query user for qst and gst
		
		//show fuckup count if needed
		
		//print receipt 
		
		
		kb.close();
	}
	
	public boolean addProduct(double price){
		
		if((price > 1.0) && (price < 1000.0)){
			mSubtotal += price;
			return true;
		}	
		
		fuckupCount++;
		return false;
	}
	
	public double getGST(){
		return fGRate * mSubtotal;
	}
	
	public double getQST(){
		return fQRate* this.getGST();
	} 
	
	/**
	 * Method used to calculate the QST given the gst has already been 
	 * separately calculate. 
	 * This reduces workload on the program, which would need to 
	 * needlessly have to recalculate the them without this method.
	 * 
	 * @param subtotal The subtotal of all the products
	 * @param gst The gst already calculated from the subtotal
	 * 
	 * @return The QST which should be added in the total.
	 */
	public double getQST(double gst){
		return fQRate * (mSubtotal + gst);
	}
	
	public double getTotal(){
		double gst = this.getGST();
		return mSubtotal + gst + this.getQST(gst);
	}
	
	public double getTotal(double gst, double qst){
		return mSubtotal + gst + qst;
	}
	
	public static void main(){
		//introduction to the program.
		System.out.printf("Welcome to Assignment 2\n\tWritten by" + AUTHOR + 
							"(%d8)%n%n%tOpenning the AbSynth Cash Register...", ID);
		new CashRegister();
		//conclusion to the program
		System.out.printf("Thank you for using the AbSynth Cash Register, good bye.");
	}
}
