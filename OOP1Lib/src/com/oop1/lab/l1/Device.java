// -----------------------------------------------------
// Lab 1
// Written by: David Boivin (40004941)
// -----------------------------------------------------

package com.oop1.lab.l1;

/**
 * A class representing a simple data structure of a device, which 
 * has a name and a price.
 * 
 * @author David Boivin (~Absynth)
 */
public class Device {

	private String mName;
	private double mPrice;
	
	/**
	 * Initializes the device with a permanent name and price. 
	 * These aren't alterable by design.
	 * 
	 * @param name The name of the device.
	 * @param price The price of the device.
	 */
	public Device(String name, double price){
		mName = name;
		mPrice = price;
	}
	
	/**
	 * @return The name of the device.
	 */
	public String getName(){
		return mName;
	}
	
	/**
	 * @return The price of the device.
	 */
	public double getPrice(){
		return mPrice;
	}
}
