// -----------------------------------------------------
// Assignment 1
// Question: 2
// Written by: David Boivin (40004941)
// -----------------------------------------------------


package com.oop1.assignments.a1;

import java.util.Scanner;

/**
 * Class which is supposed to emulate an app and music store, using constant
 * prices for both apps and songs. This implementation asks the user what
 * the desired amount of credit is in the main loop.
 * <br><br>This implementation provides features such as
 * <li>Calculating the maximum number of apps which the user can downloaded using 
 * the given credit
 * <li>Calculating the maximum number of songs and apps which can be downloaded 
 * using the given credit
 * 
 * @author David Boivin (Spit~AbSynth)
 */
public class OnlineStore {

	//constant store prices
	public final static byte SONG_PRICE = 7;
	public final static byte APP_PRICE = 3;
	
	//field representing user credit
	protected long mCredit = 0;
	
	/**
	 * Constructor which runs the main subprogram loop where the user
	 * is asked to enter a credited amount and is informed
	 * of the maximum amounts which can be purchased through the command
	 * prompt.
	 */
	public OnlineStore(){
		//variable used to store command prompt inputs from user
		//NOTE that a Scanner is already opened in GroundControl so closing the instance here will interfere with the control program
		Scanner scanner = new Scanner(System.in);
		String temp = ""; 	//useful to carry over user input
		long tempCred;		//used to provide a alterable variable to calculate
		
		//program introduction
		System.out.println("Welcome to the AbSynth Online Store.\n"
				+ "Prices:\n\tSong: 7$\n\tApp: 3$\n");
		
		//main subprogram loop
		while(true){
			//prompt user input
			System.out.println("Please enter credited amount and press [enter]"
					+ "or [e] to exit:");
			
			//retrieve input and convert
			try{
				temp = scanner.nextLine();
				mCredit = Math.abs(Long.parseLong(temp)); 		//attempts to convert
			}catch(NumberFormatException e){
				//checks if user input exit key
				if(temp.equals(GroundControl.EXIT_KEY)){
					System.out.println("Thank you for using the AbSynth Online "
							+ "Store.");
					break;
				}
				
				//report error to user
				System.out.println("The value " + temp + " isn't a valid number."
						+ "\nPlease try again.\n");
				continue;	//make user try again
			}
			
			System.out.println("With " +  mCredit + "$ you can:");
			tempCred = mCredit; //store original credit value
			
			//calculate and display amount of apps that can be bought
			System.out.println("\tPurchase " + this.getNumApps()
					+ " app(s). This will leave you with " + mCredit + "$ in"
					+ " your account." );
			
			//reset credit and calculate number of songs and apps that can be bought
			mCredit = tempCred;
			System.out.println("\tPurchase " + this.getNumSongs()
					+ " song(s) and " + + this.getNumApps() + " app(s)."
					+ " This will leave you with " + mCredit + "$ in your"
					+ "account.\n");
			
			mCredit = tempCred;//reset
		}
	}
	
	/**
	 * Method which calculates the number of apps that can be bought, given 
	 * {@link #APP_PRICE} with the credit stored in this class.
	 * <br><br><b>NOTE:</b> This method will subtract the total cost
	 * from the credit.
	 * 
	 * @return The number of apps that can be bought.
	 */
	public long getNumApps(){
		//calculate number of apps
		long apps = mCredit / APP_PRICE;
		
		//subtract total price from amount
		mCredit -= apps * APP_PRICE;
		
		return apps;
	}
	
	/**
	 * Method which calculates the number of songs that can be bought, given 
	 * {@link #SONG_PRICE} with the credit stored in this class.
	 * <br><br><b>NOTE:</b> This method will subtract the total cost
	 * from the credit.
	 * 
	 * @return The number of songs that can be bought.
	 */
	public long getNumSongs(){
		//calculates number of songs
		long songs = mCredit / SONG_PRICE;
		
		//subtract total price from amount
		mCredit -= songs * SONG_PRICE;
		
		return songs;
	}
}
