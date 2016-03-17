package com.oop1.assignments.a3;

public class LeftAlignTriangle extends Shape {

	@Override
	public String buildRow(int rowIndex) {
		StringBuilder s = new StringBuilder(mSize);
		for(int i = mSize; i > rowIndex; --i){
			s.append(i);
		}
		return String.format("%-" + mSize + "s", s.toString());
	}

}
