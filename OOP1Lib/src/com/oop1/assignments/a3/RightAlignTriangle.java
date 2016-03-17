package com.oop1.assignments.a3;

public class RightAlignTriangle extends Shape {

	@Override
	public String buildRow(int rowIndex) {
		StringBuilder s = new StringBuilder(mSize);
		for(int i = rowIndex + 1; i <= mSize; ++i){
			s.append(i);
		}
		return String.format("%" + mSize + "s", s.toString());
	}

}
