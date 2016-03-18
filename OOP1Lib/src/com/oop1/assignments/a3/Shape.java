package com.oop1.assignments.a3;

public abstract class Shape {
	
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 9;
	public static final int DEFAULT = 5;

	protected int mSize;
	
	public Shape(){
		mSize = DEFAULT;
	}
	
	public Shape(int size){
		this();
		
		this.setSize(size);
	}
	
	public int getSize(){
		return mSize;
	}
	
	public boolean setSize(int size){
		if(size > MIN_SIZE && size <= MAX_SIZE){
			mSize = size;
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		StringBuilder stringShape = new StringBuilder(mSize*(mSize+1));
		
		for(int i = 0; i < mSize; ++i){
			stringShape.append(this.buildRow(i));
			stringShape.append("\n");
		}
		
		return stringShape.toString();
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Shape)){
			return false;
		}
		
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}
	
	public static StringBuilder spaces(int n){
		StringBuilder s = new StringBuilder(n);
		for(int i = 0; i < n; ++i){
			s.append(' ');
		}
		return s;
	}
	
	public abstract String buildRow(int rowIndex);
}
