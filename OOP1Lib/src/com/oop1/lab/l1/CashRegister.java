// -----------------------------------------------------
// Lab 2
// Written by: David Boivin (40004941)
// -----------------------------------------------------

package com.oop1.lab.l1;

/**
 * The main frame of the program. This mimics a cash register
 * and builds a device hardcoded into the cash for which it calculates
 * the tax and returns the total price nicely formated.
 * 
 * @author David Boivin (~Absynth)
 */
public class CashRegister {
	
	/**
	 * The constant tax rate to be applied to each device being bought.
	 */
	public final static double TAX_RATE = 0.1;
	
	/**
	 * A quick method which allows for easy tax calculation later in the code.,
	 * 
	 * @param d The device for which to calculate the tax for.
	 * @return The net cost of the device including tax.
	 */
	public static double calculateTotalCost(Device d){
		return d.getPrice()*(1+TAX_RATE);
	}
	
	/**
	 * A method which allows for easy formatting for neat presentation of each
	 * device the user wants to buy and what the net cost is, that is cost including
	 * tax.
	 * 
	 * @param d The device for which the message is intended.
	 * @return A nicely formatted message to let the user know of the full cost of the device.
	 */
	public static String formatOutputMessage(Device d){
		return "The device named " + d.getName() + " has a final price of " 
				+ String.format("$%,.2f", CashRegister.calculateTotalCost(d)) + "$";
	}
	
	/**
	 * Creates a mock device and demonstrates the capabilities of this application.
	 */
	public static void main(String[] args) {
		Device d = new Device("Furniture", 1000.0);
		
		System.out.println("Welcome to Absynth's online store checkout.\n\n"
					+ "Pending:\nYour shopping cart contians "+ d.getName() + " (" 
					+ String.format("$%,.2f", d.getPrice())+ "$).\n\nBill:\n"
					+ CashRegister.formatOutputMessage(d) + ".");
	}

}
