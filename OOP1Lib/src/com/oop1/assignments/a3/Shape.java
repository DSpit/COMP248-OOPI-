package com.oop1.assignments.a3;

/**
 * This abstract class represents the basic form of every shape implemented in this application.
 * This class is designed to simply contain a size which can be modified at any time. This is to keep 
 * the data for this class to a minimum and allows the shape to be drawn or redrawn whenever it is needed.
 * This class is designed to only accept size values larger than {@link #MMIN_SIZE} and less than or equal
 * to {@link #MAX_SIZE}. Any shape intialized by the default constructor will have the {@link #DEFAULT} value
 * for its size.
 * 
 * 
 * @author David Boivin
 */
public abstract class Shape {
	
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 9;
	public static final int DEFAULT = 5;

	protected int mSize;
	
	/**
	 * Default constructor which initializes the shape with the {@link #DEFAULT} size.
	 */
	public Shape(){
		mSize = DEFAULT;
	}
	
	/**
	 * Conductor which initializes the shape with the given size parameter, iff the size is within
	 * the allowed range of ]{@link #MINSIZE}, {@link #MAX_SIZE}], or else initializes it with the 
	 * {@link #DEFAULT} size.
	 * 
	 * @param size The size of the shape, which should be within the range ]{@link #MINSIZE}, {@link #MAX_SIZE}].
	 */
	public Shape(int size){
		this();
		
		this.setSize(size);
	}
	
	/**
	 * Returns the size of this shape.
	 * @return The current size of the shape.
	 */
	public int getSize(){
		return mSize;
	}
	
	/**
	 * Method which must be used to set the size of this shape, which will only
	 * set it if the given size parameter is within the allowed range of 
	 * ]{@link #MINSIZE}, {@link #MAX_SIZE}].
	 * 
	 * @param size The new size of the shape, which must be within ]{@link #MINSIZE}, {@link #MAX_SIZE}] to be set.
	 * @return <b>true</b> if the size field has been updated with the new value, which is 
	 * 			between ]{@link #MINSIZE}, {@link #MAX_SIZE}] or <b>false</b> otherwise.
	 */
	public boolean setSize(int size){
		//range check
		if(size > MIN_SIZE && size <= MAX_SIZE){
			mSize = size;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Overrides the default {@link Object#toString()} implementation to create a string
	 * a shape with the x number of rows and columns, where x is the current size of the shape.
	 */
	@Override
	public String toString(){
		//initializes variables
		StringBuilder stringShape = new StringBuilder(mSize*(mSize+1));
		
		//builds the shape row by row
		for(int i = 0; i < mSize; ++i){
			stringShape.append(this.buildRow(i));
			stringShape.append("\n");
		}
		
		//returns the final form of the shape as a string.
		return stringShape.toString();
	}
	
	/**
	 * Overrides the default {@link Object#equals(Object)} method to check if
	 * the given object is, primarily, a shape, and secondly if it has the same 
	 * size as the one from which this method is called.
	 */
	@Override
	public boolean equals(Object obj){
		//checks if the object is in fact a shape
		if(!(obj instanceof Shape)){
			return false;
		}
		
		//checks if size of the shape and and the object's size are equal
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Convenience method which simply creates a {@link StringBuilder} with the given parameter
	 * amount of space characters. This is useful for aligning the shapes properly when building them.
	 * 
	 * @param n Number of space characters.
	 * @return A {@link StringBuilder} with the given amount of spaces inside.
	 */
	public static StringBuilder spaces(int n){
		StringBuilder s = new StringBuilder(n);
		for(int i = 0; i < n; ++i){
			s.append(' ');
		}
		return s;
	}
	
	/**
	 * Method which builds the row given by the rowIndex parameter. The implementation
	 * of this method should handle only index ranges between zero and totalShapeSize -1.
	 * 
	 * @param rowIndex The row index of the shape to build.
	 * @return The row, given by the rowIndex, of this shape.
	 */
	public abstract String buildRow(int rowIndex);
}
