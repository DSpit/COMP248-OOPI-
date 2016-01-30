// -----------------------------------------------------
// Assignment 1
// Question: Main Control (not part of assignment only helps navigation)
// Written by: David Boivin (40004941)
// -----------------------------------------------------

package com.oop1.assignments.a1;

import java.util.Scanner;

/**
 * This class contains the main method and will start the program for to select
 * between which part of the program the user wishes to run. If the part of the
 * assignment which the user has selected terminates or the user decides to 
 * exit the assignment part, then the user will be prompted to select another
 * part of the assignment or exit the program.
 * 
 * @author David Boivin (Spit~AbSynth)
 */
public class GroundControl {
	
	public final static String AUTHOR = "David Boivin";
	public final static int ID = 40004941;
	public final static String EXIT_KEY = "e", PART1_KEY = "1", PART2_KEY = "2";
	
	/**
	 * This is the main method of the program. It has the highest level of
	 * control over the while program. It will run in a loop prompting the
	 * user to select a part of assignment 1 or to exit the program by typing 
	 * "e".
	 * 
	 * @param args Arguments passed to this program from the call.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException{
		
		Scanner scanner = new Scanner(System.in);
		
		//introduction to the program.
		System.out.println("Welcome to Assignment 1\n\tWritten by " + AUTHOR + 
							"(" + ID + ")");
		
		while(true){
			
			//present options to user
			System.out.println("\nPlease type [" + PART1_KEY + "] to select a1p1 "
					+ "or [" + PART2_KEY + "] for a1p2.\nTo exit please type ["
					+  EXIT_KEY + "], this will terminate the program.\nWhen you"
					+ " have made your choice, press [enter]. Only the first word "
					+ "will be considered (delimited by whitespaces).");
			
			//based on user input, decides what actions to perform.
			switch(scanner.nextLine().trim().toLowerCase()){
			case PART1_KEY:							//case: part 1 selected
				System.out.println("\n");
				(new MyFirstProgram(AUTHOR, "Friday January 8, 2016", "2:45 AM", 
						false)).echoMessage();
				break;
				
			case PART2_KEY:							//case: part 2 selected
				System.out.println("\n");
				new OnlineStore();
				break;
				
			case EXIT_KEY:						//case: exit program
				System.out.println("Thank you for viewing Assignment 1. Program "
						+ "will end.");
				scanner.close();	//XXX save em resources
				System.exit(0);										//EXIT BRANCH
				
			default:							//case: unsupported character
				System.out.println("That input doesn't mean anything to me,"
						+ "please reread the allowed inputs.\n");
		
			}
		}
	}
}
