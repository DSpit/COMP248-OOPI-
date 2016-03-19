package com.oop1.assignments.a4;

/**
 * This class contains the main method of a program that showcases the the {@link CellPhone} class.
 * 
 * @author David Boivin
 */
public class UtilizeCellPhone {

	public static void main(String[] args) {
		//create cell set
		CellPhone[] cells = {new CellPhone("Apple iPhone 6", 100000000, 711.69), 
				new CellPhone("Samsung Galaxy s6", 200000000, 650.70),
				new CellPhone("Google Nexus 5", 300000000, 420.42)};
		
		//output all info of each cell
		for(int i = 0; i < cells.length; ++i){
			System.out.println("CellPhone " + (i+1) + "\n" + cells[i]);
		}
		
		//modify and display changes
		cells[0].setPrice(611.69);
		System.out.printf("%s has price %.2f%n", cells[0].getBrand(), cells[0].getPrice());
		cells[1].setBrand("Samsung Galaxy s5");
		cells[1].setPrice(550.70);
		System.out.printf("%s has price %.2f%n", cells[1].getBrand(), cells[1].getPrice());
		cells[2].setSerialNumber(400000000);
		System.out.printf("%s has serial number %9d%n", cells[2].getBrand(), cells[2].getSerialNumber());
		System.out.println();
		
		//comparison test
		System.out.println("Are Cell 1 and cell 2 equal: " + cells[0].equals(cells[1]));
		System.out.println("Are Cell 2 and cell 3 equal: " + cells[1].equals(cells[2]));
		System.out.println("Are Cell 1 and cell 3 equal: " + cells[0].equals(cells[2]));
		System.out.println("Are Cell 1 and a copy of Cell 1 equal: " + cells[0].equals(new CellPhone(cells[0])));
	}

}
