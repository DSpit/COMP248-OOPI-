package com.oop1.assignments.a3;


public class Diamond extends Shape {

	@Override
	public String buildRow(int rowIndex) {
		StringBuilder s = new StringBuilder(mSize);
		rowIndex = (rowIndex >=  mSize/2)? (mSize-1) - rowIndex: rowIndex;
		
		s.append(Shape.spaces((mSize-2*rowIndex+2)/2));
		for(int i = 0; i < (2*rowIndex+1); ++i){
			s.append(i + 1);
		}
		s.append(Shape.spaces((mSize-2*rowIndex+2)/2));
		
		return s.toString();
	}

}
