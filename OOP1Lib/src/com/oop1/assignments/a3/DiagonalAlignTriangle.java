package com.oop1.assignments.a3;


public class DiagonalAlignTriangle extends Shape {

	@Override
	public String buildRow(int rowIndex) {
		StringBuilder s = new StringBuilder(mSize);
		for(int i = 1; i <= rowIndex + 1; ++i){
			s.append(i);
		}
		return String.format("%" + mSize + "s", s.toString());
	}

}
