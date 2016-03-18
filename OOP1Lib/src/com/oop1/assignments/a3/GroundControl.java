package com.oop1.assignments.a3;

import java.util.Scanner;

public class GroundControl {
	
	public final static String AUTHOR = "David Boivin";
	public final static int ID = 40004941;
	public final static int QUIT = 5;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String patternChooserString = GroundControl.buildPatternChooserString();
		Shape shape = null;
		
		System.out.printf("Welcome to %s's Triangle and Diamond Printer%n%n", AUTHOR);
		
		while(true){
			System.out.printf("%s%nPlease choose the pattern you wish to print or %d to quit:", patternChooserString, QUIT);
			
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
					kb.close();
					System.exit(0);
					
				default:
					System.out.print("Sorry that wasn't an option, try again:");
				}
				
			}
			
			int size = -1;
			do{
				System.out.printf("Please enter the size of the shape (between ]%d and %d]):",
						Shape.MIN_SIZE, Shape.MAX_SIZE);
				size = kb.nextInt();
			}while(!shape.setSize(size));
			
			System.out.println(shape.toString());
			shape = null;
		}

	}
	
	private static String buildPatternChooserString(){
		StringBuilder s = new StringBuilder(4*((Shape.DEFAULT+1)*Shape.DEFAULT + 3*(Shape.DEFAULT+1)) + Shape.DEFAULT+1);	//whitespace + ln characters + shapes
		Shape[] shapes = {new LeftAlignTriangle(), new RightAlignTriangle(),
				new DiagonalAlignTriangle(), new Diamond()};
		
		for(int i = 1; i < QUIT; ++i){
			s.append( i + ") " +  Shape.spaces(Shape.DEFAULT));
		}
		s.append("\n");
		
		for(int i = 0; i < Shape.DEFAULT; ++i){
			for(int j = 0; j < shapes.length; ++j){
				s.append(Shape.spaces(3));
				s.append(shapes[j].buildRow(i));
			}
			s.append("\n");
		}
		
		return s.toString();
	}

}
