package com.oop1.assignments.a3;

/**
 * Class which extends {@link Shape} to build a triangle with the ones 
 * aligned on the diagonal and the base aligned to the bottom.
 * 
 * <br><br> Here is an example of the default shape that will be build by this class:
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;123
 * <br>&nbsp;&nbsp;1234
 * <br>12345
 * 
 * @author David Boivin
 *
 */
public class DiagonalAlignTriangle extends Shape {

	/**
	 * Method which builds the row by appending numbers starting from 1, 
	 * increasing by one, until row index parameter +1. 
	 */
	@Override
	public String buildRow(int rowIndex) {
		//makes sure the row index is legal
		if(rowIndex > mSize || rowIndex < 0){
			return "";
		}
		
		//Initializes variables and builds the row
		StringBuilder s = new StringBuilder(mSize);
		s.append(Shape.spaces(mSize - rowIndex-1)); //adds necessary whitespace before numbers
		for(int i = 1; i <= rowIndex + 1; ++i){
			s.append(i);
		}
		
		//returns the finished shape in string form
		return s.toString();
	}
	
	/**
	 * Overrides the {@link Shape#equals(Object)} to check if the object
	 * is a {@link DiagonalAlignTriangle} and then checks the size.
	 */
	@Override
	public boolean equals(Object obj){
		//checks if the object is a DiagonalAlignTriangle
		if(!(obj instanceof DiagonalAlignTriangle)){
			return false;
		}
		
		//checks the size
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}

}
