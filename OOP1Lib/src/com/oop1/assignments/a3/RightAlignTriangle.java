package com.oop1.assignments.a3;

/**
 * Class which extends {@link Shape} to build a triangle with its highest number 
 * aligned to the right side and the base aligned to the top.
 * 
 * <br><br> Here is an example of the default shape that will be build by this class:
 * <br>12345
 * <br>&nbsp;&nbsp;2345
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;345
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;45
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5  
 * 
 * @author David Boivin
 *
 */
public class RightAlignTriangle extends Shape {

	/**
	 * Method which builds the row with the highest number aligned to the right and
	 * will only append the numbers (increasing by one) after the row index parameter given.
	 */
	@Override
	public String buildRow(int rowIndex) {
		//makes sure the row index is legal
		if(rowIndex > mSize || rowIndex < 0){
			return "";
		}
		
		//initializes necessary variables and builds the row
		StringBuilder s = new StringBuilder(mSize);
		s.append(Shape.spaces(rowIndex));	//add needed whitespace before shape to align it properly
		for(int i = rowIndex + 1; i <= mSize; ++i){
			s.append(i);
		}
		
		//return final shape
		return s.toString();
	}
	
	/**
	 * Overrides the {@link Shape#equals(Object)} to check if the object
	 * is a {@link RightAlignTriangle} and then checks the size.
	 */
	@Override
	public boolean equals(Object obj){
		//checks if the object is a RightAlignTriangle
		if(!(obj instanceof RightAlignTriangle)){
			return false;
		}
		
		//checks the size
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}

}
