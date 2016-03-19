package com.oop1.assignments.a3;

/**
 * Class which extends {@link Shape} to build a diamond with the center row 
 * having the largest amount of numbers.
 * 
 * <br><br> Here is an example of the default shape that will be build by this class:
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;1   
 * <br>&nbsp;&nbsp;123  
 * <br>12345 
 * <br>&nbsp;&nbsp;123  
 * <br>&nbsp;&nbsp;&nbsp;&nbsp;1  
 * <br><br>Note: that if the size of the Diamond is even then the shape shall look like:
 * <br>&nbsp;&nbsp;1   
 * <br>  123  
 * <br>  123  
 * <br>&nbsp;&nbsp;1  
 * 
 * @author David Boivin
 *
 */
public class Diamond extends Shape {

	/**
	 * Method which builds the row by using the formula <code>2*rowIndex+1</code> 
	 * to select the amount of numbers to put in the row. The numbers are centered 
	 * in the row by using the formula <code>(mSize-2*rowIndex+2)/2)</code> to add 
	 * whitespace before and after the numbers.
	 */
	@Override
	public String buildRow(int rowIndex) {
		//makes sure the row index is legal
		if(rowIndex >= mSize || rowIndex < 0){
			return "";
		}
		
		//initializes variables
		StringBuilder s = new StringBuilder(mSize);
		rowIndex = (rowIndex >=  mSize/2)? (mSize-1) - rowIndex: rowIndex;	//adjusts the row index to take into consideration the bottom half of the diamond
		
		//populates the row according to the given formulas
		s.append(Shape.spaces((mSize-2*rowIndex+2)/2));
		for(int i = 0; i < (2*rowIndex+1); ++i){
			s.append(i + 1);
		}
		s.append(Shape.spaces((mSize-2*rowIndex+2)/2));
		
		//returns the finalized string
		return s.toString();
	}
	
	/**
	 * Overrides the {@link Shape#equals(Object)} to check if the object
	 * is a {@link Diamond} and then checks the size.
	 */
	@Override
	public boolean equals(Object obj){
		//checks if the object is a DiagonalAlignTriangle
		if(!(obj instanceof Diamond)){
			return false;
		}
		
		//checks the size
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}

}
