// -----------------------------------------------------
// Assignment 1
// Question: 1
// Written by: David Boivin (40004941)
// -----------------------------------------------------

package com.oop1.assignments.a1;

/**
 * This is an introductory program designed to output a message to
 * introduce myself to the world. Essentially this is a Hello World program
 * which is supposed to also output the name of the author and the time
 * the class was written (hard-coded). 
 * 
 * @author David Boivin (Spit~AbSynth)
 */
public class MyFirstProgram {
	
	//constants which are used in the program and can be accessed (but not 
	//changed) by other classes. A feature which enables string matching 
	//algorithms to read the message easily and extract information.
	public final static String INDIVIDUALLY = "individually";
	public final static String IN_GROUP = "in a group";

	//set of fields used to store important info about user 
	//which can be later used and possibly altered by classes
	//which inherit this class
	protected String mAuthor, mDate, mTime;
	protected boolean mIsGrouped;
	
	/**
	 * Constructor which fills in all of the fields, which allows this
	 * class to be prepared to output the hello world message.
	 * 
	 * @param author The author of the program calling this class.
	 * @param date The date which the author has written the program.
	 * @param time The time of day which the program has been written, 
	 * 														including AM or PM.
	 * @param isInGroup Whether the author had a partner when writing the
	 * 															calling code.
	 */
	public MyFirstProgram(String author, String date, String time, 
														boolean isInGroup){
		mAuthor = author;
		mDate =  date;
		mTime = time;
		mIsGrouped = isInGroup;
	}
	
	/**
	 * Method which outputs an introductory message using this class' fields
	 * for the parts which are user dependent. This method will output in the
	 * command prompt, and will be formatted in the classic 70s style.
	 */
	public void echoMessage(){
		System.out.println("Hello World! Welcome to my first program!\n" +
							"This program was written by " + mAuthor + ".\n" + 
							"The assingment was done " + 
							((mIsGrouped) ? IN_GROUP : INDIVIDUALLY) + 
							" on " + mDate + " at " + mTime + ".\n" + 
							"End of Program!");
	}
	
	/**
	 * Main method in case the teacher decides to be anal and not accept my GroundControl navigation program.
	 * The assignment is much more unified if the program is launched from GroundControl.
	 */
	public static void main(String[] args){
		(new MyFirstProgram(GroundControl.AUTHOR, "Friday January 8, 2016", "2:45 AM", 
				false)).echoMessage();
	}
}
