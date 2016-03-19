package com.oop1.assignments.a3;

/**
 * Class which extends {@link Shape} to build a triangle with its highest number 
 * aligned to the left side and the base aligned to the top.
 * 
 * <br><br> Here is an example of the default shape that will be build by this class:
 * <br>54321
 * <br>5432 
 * <br>543  
 * <br>54   
 * <br>5     
 * 
 * @author David Boivin
 *
 */
public class LeftAlignTriangle extends Shape {

	/**
	 * Method which builds the row with the highest number aligned to the left and
	 * will only append the numbers (decreasing by one) up until the row index parameter given.
	 */
	@Override
	public String buildRow(int rowIndex) {
		//makes sure the row index is legal
		if(rowIndex > mSize || rowIndex < 0){
			return "";
		}
		
		//Initializes variables and builds the row
		StringBuilder s = new StringBuilder(mSize);
		for(int i = mSize; i > rowIndex; --i){
			s.append(i);
		}
		
		//adds the whitespace at the end and returns the row
		s.append(Shape.spaces(rowIndex));
		return s.toString();
	}
	
	/**
	 * Overrides the {@link Shape#equals(Object)} to check if the object
	 * is a {@link LeftAlignTriangle} and then checks the size.
	 */
	@Override
	public boolean equals(Object obj){
		//checks if the object is a LeftAlignTriangle
		if(!(obj instanceof LeftAlignTriangle)){
			return false;
		}
		
		//checks the size
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}

}
