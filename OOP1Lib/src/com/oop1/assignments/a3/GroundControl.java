package com.oop1.assignments.a3;

import java.util.Scanner;

/**
 * This class contains the main program loop, which introduces the Triangle/Diamond drawing tool,
 * and allows the user to discover 4 different patterns. The user can choose any of these patterns
 * and select row numbers between ]1,9], which dictates the size (or number of rows) which the 
 * selected shape pattern will be drawn with. This program will loop until the user selects the
 * {@link #QUIT} option.
 * 
 * @author David Boivin
 */
public class GroundControl {
	
	public final static String AUTHOR = "David Boivin";
	public final static int ID = 40004941;
	public final static int QUIT = 5;
	private final static int WHITESPACE = 3;

	public static void main(String[] args) {
		//creates all necessary variables 
		Scanner kb = new Scanner(System.in);
		String patternChooserString = GroundControl.buildPatternChooserString();
		Shape shape = null;
		
		//introduces the program
		System.out.printf("Welcome to %s's Triangle and Diamond Printer%n%n", AUTHOR);
		
		//main loop
		while(true){
			//prompts the user to choose a pattern
			System.out.printf("%s%nPlease choose the pattern you wish to print or %d to quit:", patternChooserString, QUIT);
			
			//select shape
			while(shape == null){
				switch(kb.nextInt()){
				case 1:						//left align
					shape = new LeftAlignTriangle();
					break;
					
				case 2:						//right align
					shape = new RightAlignTriangle();
					break;
					
				case 3:						//diagonal align
					shape = new DiagonalAlignTriangle();
					break;
					
				case 4:						//diamond
					shape = new Diamond();
					break;
					
				case QUIT:					//quit
					System.out.printf("Thank you for using %s Triangle and Diamond Printer", AUTHOR);
					kb.close();	//save em resources
					System.exit(0);
					
				default:
					System.out.print("Sorry that wasn't an option, try again:");	//someone's done fucked up
				}
				
			}
			
			//select shape size
			int size = -1;
			do{
				System.out.printf("Please enter the size of the shape (between ]%d and %d]):",
						Shape.MIN_SIZE, Shape.MAX_SIZE);	//user prompt
				size = kb.nextInt();	//get user answer
			}while(!shape.setSize(size));	//only allows the shape to be drawn if it is within the accepted range
			
			//build and display selected shape
			System.out.println(shape.toString());
			shape = null; //reset shape for next iteration 
		}

	}
	
	/**
	 * Convenience method which builds the pattern options for the user to have an
	 * idea what they are choosing and what the shape will look like. The options 
	 * string is built from a {@link StringBuilder} which and appending each shape
	 * in one big StringBuilder, which is then turned into a string. The options
	 * are built from the default shape size, given by {@link Shape#DEFAULT}.
	 * 
	 * @return A string representing all the shape options the user can choose from.
	 */
	private static String buildPatternChooserString(){
		//creates and instantiates necessary variables
		Shape[] shapes = {new LeftAlignTriangle(), new RightAlignTriangle(),
				new DiagonalAlignTriangle(), new Diamond()};
		StringBuilder s = new StringBuilder((Shape.DEFAULT+1)*(shapes.length*(WHITESPACE+Shape.DEFAULT) + 1));	//numbers + whitespace + ln characters + shapes
		
		//creates first line, which contains the option numbers and whitespace for the shapes one the next lines
		for(int i = 1; i < QUIT; ++i){
			s.append( i + ") " +  Shape.spaces(Shape.DEFAULT));
		}
		s.append("\n");
		
		//builds each line using the correct row of every shape and adding the necessary whitespace 
		//in between each shape to compensate for the option numbers.
		for(int i = 0; i < Shape.DEFAULT; ++i){
			for(int j = 0; j < shapes.length; ++j){
				s.append(Shape.spaces(WHITESPACE));
				s.append(shapes[j].buildRow(i));
			}
			s.append("\n");
		}
		
		//returns the string
		return s.toString();
	}

}
